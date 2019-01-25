package womobean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.KundeDAO;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;
import womomodel.Kunde;

@Named
@SessionScoped
public class KundeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	KundeDAO dao;
	
	public List<Kunde> getAll(){
		return dao.findAll();
	}
	
	public HashMap<String, Integer> getAllDropdown(){
		HashMap<String, Integer> kunden = new HashMap<String, Integer>();
		for(Kunde kunde : dao.findAll()) {
			kunden.put(kunde.getVorname() + " " + kunde.getNachname(), kunde.getIdKunde());
		}
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
         
        if(dao.add(vorname, nachname, strasse, plz, ort)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kunde hinzugefügt", "Name: " + vorname + " " + nachname);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen", "Kunde konnte nicht eingefügt werden.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
