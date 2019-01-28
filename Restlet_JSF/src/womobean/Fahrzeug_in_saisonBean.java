package womobean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import service.WoMoService;
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
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage message = null;

        if(dao.update((Fahrzeug_in_saison)event.getObject())) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fahrzeug in Saison bearbeitet", "Fahrgestellnummer: " + ((Fahrzeug_in_saison) event.getObject()).getFahrgestellNr());
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Bearbeiten", "Fahrzeug in Saison konnte nicht bearbeitet werden.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	 FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen", "Fahrgestellnummer: " + ((Fahrzeug_in_saison) event.getObject()).getFahrgestellNr());
         FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
