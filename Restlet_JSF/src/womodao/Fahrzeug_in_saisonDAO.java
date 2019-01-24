package womodao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Fahrzeug_in_saison;
import java.io.Serializable;

@Named
@SessionScoped
public class Fahrzeug_in_saisonDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	WoMoService service;
	
	public List<Fahrzeug_in_saison> findAll(){
		Query<Fahrzeug_in_saison> query = service.createFahrzeug_in_saisonQuery("/fahrzeug_in_saison");
		List<Fahrzeug_in_saison> fahrzeuge = new ArrayList<>();
		for(Fahrzeug_in_saison fahrzeug : query) {
			fahrzeuge.add(fahrzeug);
		}
		return fahrzeuge;
	}
}
