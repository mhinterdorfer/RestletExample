package womodao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoServiceService;
import womomodel.Fahrzeug;

@Named
@RequestScoped
public class FahrzeugDAO {
	@Inject 
	WoMoServiceService service;
	
	public List<Fahrzeug> findAll(){
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs");
		List<Fahrzeug> fahrzeuge = new ArrayList<>();
		for(Fahrzeug fahrzeug : query) {
			fahrzeuge.add(fahrzeug);
		}
		return fahrzeuge;
	}

}
