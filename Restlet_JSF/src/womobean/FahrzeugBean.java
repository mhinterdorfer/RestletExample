package womobean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import womodao.FahrzeugDAO;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;
import womomodel.Standort;

import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class FahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Fahrzeug> fahrzeuge = new ArrayList<>();
	
	@Inject
	FahrzeugDAO dao;
	
	@PostConstruct
	public void init() {
		this.fahrzeuge = dao.findAll();
	}
	
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
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage message = null;
		Fahrzeug edit = (Fahrzeug)event.getObject();
        if(dao.update(edit)) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fahrzeug bearbeitet", "Fahrgestellnummer: " + ((Fahrzeug) event.getObject()).getFahrgestellNr() + ", " + ((Fahrzeug) event.getObject()).getMarke());
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Bearbeiten", "Fahrzeug konnte nicht bearbeitet werden.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public void onRowCancel(RowEditEvent event) {
    	 FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen", "Fahrgestellnummer: " + ((Fahrzeug) event.getObject()).getFahrgestellNr());
         FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void reload() {
    	try {
    		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    	}catch (IOException ex) {
    		ex.printStackTrace();
    	}
        
    }

	public List<Fahrzeug> getFahrzeuge() {
		return fahrzeuge;
	}

	public void setFahrzeuge(List<Fahrzeug> fahrzeuge) {
		this.fahrzeuge = fahrzeuge;
	}

}
