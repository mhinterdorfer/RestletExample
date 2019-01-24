package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;

@ManagedBean
@SessionScoped
public class FahrzeugDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	transient private WoMoService service;
	
	public List<Fahrzeug> findAll(){
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs");
		List<Fahrzeug> fahrzeuge = new ArrayList<>();
		for(Fahrzeug fahrzeug : query) {
			fahrzeuge.add(fahrzeug);
		}
		return fahrzeuge;
	}
	
	public Fahrzeug getById(int id) {
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs(" + id + ")");
		return query.iterator().next();
	}
}
