package womobean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import womodao.MietfahrzeugDAO;
import womomodel.Fahrzeug_in_saison;
import womomodel.Kunde;
import womomodel.Mietfahrzeug;

@Named
@RequestScoped
public class MietfahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Mietfahrzeug> fahrzeuge = new ArrayList<>();

	@Inject
	MietfahrzeugDAO dao;

	@Inject
	LoginBean login;

	@PostConstruct
	public void init() {
		if (login.getKundenNR() != null) {
			this.fahrzeuge = dao.findAllFiltered(login.getKundenNR());
		} else {
			this.fahrzeuge = dao.findAll();
		}
	}

	public List<Mietfahrzeug> getAll() {
		if (login.getKundenNR() != null) {
			return dao.findAllFiltered(login.getKundenNR());
		} else {
			return dao.findAll();
		}
	}

	public Mietfahrzeug getById(int id) {
		return dao.getById(id);
	}

	public void add(String fahrgestellNr, String kundenNr, String saison, Date datumVon, Date datumBis) {
		FacesMessage message = null;

		try {
			if (dao.add(Integer.parseInt(fahrgestellNr), Integer.parseInt(kundenNr), Integer.parseInt(saison), datumVon,
					datumBis)) {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mietfahrzeug hinzugefügt",
						"Fahrgestellnummer: " + fahrgestellNr + ", Datum: " + datumVon + " - " + datumBis);
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen",
						"Mietfahrzeug konnte nicht eingefügt werden.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage message = null;
		Mietfahrzeug edit = (Mietfahrzeug) event.getObject();
		if (dao.update(edit)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mietfahrzeug bearbeitet",
					"Fahrgestellnummer: " + edit.getFahrgestellNr());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Bearbeiten",
					"Mietfahrzeug konnte nicht bearbeitet werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen",
				"Kundennummer: " + ((Kunde) event.getObject()).getIdKunde());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void delete(Mietfahrzeug fahrzeug) {
		FacesMessage message = null;
		if (dao.delete(fahrzeug)) {
			fahrzeuge.remove(fahrzeug);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mietfahrzeug gelöscht",
					"Fahrgestellnummer: " + fahrzeug.getFahrgestellNr());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Löschen",
					"Mietfahrzeug konnte nicht gelöscht werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Mietfahrzeug> getFahrzeuge() {
		return fahrzeuge;
	}

	public void setFahrzeuge(List<Mietfahrzeug> fahrzeuge) {
		this.fahrzeuge = fahrzeuge;
	}

}
