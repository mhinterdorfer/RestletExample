package womobean;

import java.io.Serializable;
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

import womodao.StandortDAO;
import womomodel.Standort;

@Named
@SessionScoped
public class StandortBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Standort> standorte = new ArrayList<>();

	@Inject
	StandortDAO dao;

	@PostConstruct
	public void init() {
		this.standorte = dao.findAll();
	}

	public List<Standort> getAll() {
		return dao.findAll();
	}

	public HashMap<String, Integer> getAllDropdown() {
		HashMap<String, Integer> standorte = new HashMap<String, Integer>();
		for (Standort standort : dao.findAll()) {
			standorte.put(standort.getBezeichnung(), standort.getIdStandort());
		}
		return standorte;
	}

	public Standort getById(int id) {
		return dao.getById(id);
	}

	public void add(int standortNr, String bezeichnung, String strasse, int plz, String ort) {
		FacesMessage message = null;

		if (dao.add(standortNr, bezeichnung, strasse, plz, ort)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Standort hinzugefügt", "Name: " + bezeichnung);
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen",
					"Standort konnte nicht eingefügt werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage message = null;
		Standort edit = (Standort) event.getObject();
		if (dao.update(edit)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Standort bearbeitet",
					"Standortnummer: " + edit.getIdStandort());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Bearbeiten",
					"Standort konnte nicht bearbeitet werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen",
				"Standortnummer: " + ((Standort) event.getObject()).getIdStandort());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public List<Standort> getStandorte() {
		return standorte;
	}

	public void setStandorte(List<Standort> standorte) {
		this.standorte = standorte;
	}

}
