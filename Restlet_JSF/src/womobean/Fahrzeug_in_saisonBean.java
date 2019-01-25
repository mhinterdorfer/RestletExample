package womobean;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.Fahrzeug_in_saisonDAO;
import womomodel.Fahrzeug_in_saison;
import java.io.Serializable;

@Named
@SessionScoped
public class Fahrzeug_in_saisonBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	Fahrzeug_in_saisonDAO dao;

	public List<Fahrzeug_in_saison> getAll() {
		return dao.findAll();
	}
	
	public Fahrzeug_in_saison getById(int id) {
		return dao.getById(id);
	}
	
	public void add(int fahrgestellNr, int saison, double tagespreis) {
		FacesMessage message = null;
         
        if(dao.add(fahrgestellNr, saison, tagespreis)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fahrzeug in Saison hinzugefügt", "Fahrgestellnummer: " + fahrgestellNr);
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen", "Fahrzeug in Saison konnte nicht eingefügt werden.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
