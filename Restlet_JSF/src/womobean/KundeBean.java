package womobean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import womodao.KundeDAO;
import womomodel.Fahrzeug_in_saison;
import womomodel.Kunde;

@Named
@RequestScoped
public class KundeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Kunde> kunden = new ArrayList<>();

	@Inject
	KundeDAO dao;

	@PostConstruct
	public void init() {
		this.kunden = dao.findAll();
	}

	public List<Kunde> getAll() {
		return dao.findAll();
	}

	public HashMap<String, Integer> getAllDropdown() {
		HashMap<String, Integer> kunden = new HashMap<String, Integer>();
		for (Kunde kunde : dao.findAll()) {
			kunden.put(kunde.getVorname() + " " + kunde.getNachname(), kunde.getIdKunde());
		}
		return kunden;
	}

	public HashMap<String, Integer> getSingleDropdown(int kundenNr) {
		HashMap<String, Integer> kunden = new HashMap<String, Integer>();
		kunden.put(dao.getById(kundenNr).getVorname() + " " + dao.getById(kundenNr).getNachname(),
				dao.getById(kundenNr).getIdKunde());
		return kunden;
	}

	public Kunde getById(int id) {
		return dao.getById(id);
	}

	public Kunde findByParameters(String vn, String nn, String str, String plz, String ort) {
		return dao.findByParameters(vn, nn, str, plz, ort);
	}

	public void add(String vorname, String nachname, String strasse, int plz, String ort) {
		FacesMessage message = null;

		if (dao.add(vorname, nachname, strasse, plz, ort)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kunde hinzugefügt",
					"Name: " + vorname + " " + nachname);
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen",
					"Kunde konnte nicht eingefügt werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage message = null;
		Kunde edit = (Kunde) event.getObject();
		if (dao.update(edit)) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kunde bearbeitet",
					"Kundennummer: " + edit.getIdKunde());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Bearbeiten",
					"Kunde konnte nicht bearbeitet werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen",
				"Kundennummer: " + ((Kunde) event.getObject()).getIdKunde());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void delete(Kunde kunde) {
		FacesMessage message = null;
		if (dao.delete(kunde)) {
			kunden.remove(kunde);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kunde gelöscht",
					"Kundennummer: " + kunde.getIdKunde());
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Löschen",
					"Kunde konnte nicht gelöscht werden.");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public List<Kunde> getKunden() {
		return kunden;
	}

	public void setKunden(List<Kunde> kunden) {
		this.kunden = kunden;
	}

}
