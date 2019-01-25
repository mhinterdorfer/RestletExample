package womobean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.SaisonDAO;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;
import womomodel.Saison;

@Named
@SessionScoped
public class SaisonBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	SaisonDAO dao;
	
	public List<Saison> getAll(){
		return dao.findAll();
	}
	
	public HashMap<String, Integer> getAllDropdown(){
		HashMap<String, Integer> saisonen = new HashMap<String, Integer>();
		for(Saison saison : dao.findAll()) {
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
			if(dao.add(saisonNr, name, new Date(new SimpleDateFormat("dd/MM/yyyy").parse(datumVon).getTime()), new Date(new SimpleDateFormat("dd/MM/yyyy").parse(datumBis).getTime()))) {
			    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saison hinzugefügt", "Saisonnummer: " + saisonNr + ", Datum: " + datumVon + " - " + datumBis);
			} else {
			    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler beim Einfügen", "Saison konnte nicht eingefügt werden.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
