package womobean;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.MietfahrzeugDAO;
import womomodel.Fahrzeug_in_saison;
import womomodel.Mietfahrzeug;

@Named
@SessionScoped
public class MietfahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	MietfahrzeugDAO dao;
	
	public List<Mietfahrzeug> getAll(){
		return dao.findAll();
	}
	
	public Mietfahrzeug getById(int id) {
		return dao.getById(id);
	}
	
	public void add(String fahrgestellNr, String kundenNr, String saison, String datumVon, String datumBis) {
		FacesMessage message = null;
		
        try {
			if(dao.add(Integer.parseInt(fahrgestellNr), Integer.parseInt(kundenNr), Integer.parseInt(saison), new Date(new SimpleDateFormat("dd/MM/yyyy").parse(datumVon).getTime()), new Date(new SimpleDateFormat("dd/MM/yyyy").parse(datumBis).getTime()))) {
			    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mietfahrzeug hinzugefügt", "Fahrgestellnummer: " + fahrgestellNr + ", Datum: " + datumVon + " - " + datumBis);
			} else {
			    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen", "Mietfahrzeug konnte nicht eingefügt werden.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
