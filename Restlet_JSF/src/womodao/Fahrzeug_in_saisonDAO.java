package womodao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Fahrzeug_in_saison;
import womomodel.Saison;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Fahrzeug_in_saisonDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	transient private WoMoService service;
	
	public List<Fahrzeug_in_saison> findAll(){
		Query<Fahrzeug_in_saison> query = service.createFahrzeug_in_saisonQuery("/fahrzeug_in_saison");
		List<Fahrzeug_in_saison> fahrzeuge = new ArrayList<>();
		for(Fahrzeug_in_saison fahrzeug : query) {
			fahrzeuge.add(fahrzeug);
		}
		return fahrzeuge;
	}
	
	public Fahrzeug_in_saison getById(int id) {
		Query<Fahrzeug_in_saison> query = service.createFahrzeug_in_saisonQuery("/fahrzeug_in_saison(" + id + ")");
		return query.iterator().next();
	}

	public boolean add(int fahrgestellNr, int saison, double tagespreis) {
		try {
			Fahrzeug_in_saison fahrzeug = new Fahrzeug_in_saison();
			fahrzeug.setFahrgestellNr(fahrgestellNr);
			fahrzeug.setIdSaison(saison);
			fahrzeug.setTagespreis(tagespreis);
			service.addEntity(fahrzeug);
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Fahrzeug_in_saison fahrzeug) {
		try {
			service.updateEntity(fahrzeug);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
