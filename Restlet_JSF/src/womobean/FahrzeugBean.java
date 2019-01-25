package womobean;

import java.util.HashMap;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.FahrzeugDAO;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;
import womomodel.Standort;

import java.io.Serializable;

@Named
@SessionScoped
public class FahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	FahrzeugDAO dao;
	
	public List<Fahrzeug> getAll(){
		return dao.findAll();
	}
	
	public HashMap<Integer, Integer> getAllDropdown(){
		HashMap<Integer, Integer> fahrzeugNr = new HashMap<Integer, Integer>();
		for(Fahrzeug fahrzeug : dao.findAll()) {
			fahrzeugNr.put(fahrzeug.getFahrgestellNr(), fahrzeug.getFahrgestellNr());
		}
        return fahrzeugNr;
	}
	
	public Fahrzeug getById(int id) {
		return dao.getById(id);
	}
	
	public void add(int fahrgestellNr, String marke, String typ, int standort) {
		FacesMessage message = null;
         
        if(dao.add(fahrgestellNr, marke, typ, standort)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fahrzeug hinzugefügt", "Fahrgestellnummer: " + fahrgestellNr);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen", "Fahrzeug konnte nicht eingefügt werden.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
