package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Fahrzeug;

@Named
@SessionScoped
public class FahrzeugDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	WoMoService service;
	
	public List<Fahrzeug> findAll(){
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs");
		List<Fahrzeug> fahrzeuge = new ArrayList<>();
		for(Fahrzeug fahrzeug : query) {
			fahrzeuge.add(fahrzeug);
		}
		return fahrzeuge;
	}
}
