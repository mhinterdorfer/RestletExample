package womobean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import womodao.SaisonDAO;
import womomodel.Saison;

@Named
@SessionScoped
public class SaisonBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Saison> saisonen = new ArrayList<>();

	@Inject
	SaisonDAO dao;

	@PostConstruct
	public void init() {
		this.saisonen = dao.findAll();
	}

	public List<Saison> getAll() {
		return dao.findAll();
	}

	public HashMap<String, Integer> getAllDropdown() {
		HashMap<String, Integer> saisonen = new HashMap<String, Integer>();
		for (Saison saison : dao.findAll()) {
			saisonen.put(saison.getName(), saison.getIdSaison());
		}
		return saisonen;
	}

	public Saison getById(int id) {
		return dao.getById(id);
	}

	public void add(int saisonNr, String name, String datumVon, String datumBis) {
		FacesMessage message = null;

		try {
			if (dao.add(saisonNr, name, new Date(new SimpleDateFormat("dd/MM/yyyy").parse(datumVon).getTime()),
					new Date(new SimpleDateFormat("dd/MM/yyyy").parse(datumBis).getTime()))) {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saison hinzugefügt",
						"Saisonnummer: " + saisonNr + ", Datum: " + datumVon + " - " + datumBis);
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen",
						"Saison konnte nicht eingefügt werden.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage message = null;
		Saison edit = (Saison) event.getObject();
		if (dao.update(edit)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saison bearbeitet",
					"Saison-ID: " + edit.getIdSaison());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Bearbeiten",
					"Saison konnte nicht bearbeitet werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen",
				"Kundennummer: " + ((Saison) event.getObject()).getIdSaison());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Saison> getSaisonen() {
		return saisonen;
	}

	public void setSaisonen(List<Saison> saisonen) {
		this.saisonen = saisonen;
	}

}
