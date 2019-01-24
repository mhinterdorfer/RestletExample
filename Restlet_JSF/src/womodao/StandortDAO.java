package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Mietfahrzeug;
import womomodel.Standort;

@ManagedBean
@SessionScoped
public class StandortDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	transient private WoMoService service;
	
	public List<Standort> findAll(){
		Query<Standort> query = service.createStandortQuery("/Standorts");
		List<Standort> standorte = new ArrayList<>();
		for(Standort standort : query) {
			standorte.add(standort);
		}
		return standorte;
	}
	
	public Standort getById(int id) {
		Query<Standort> query = service.createStandortQuery("/Standorts(" + id + ")");
		return query.iterator().next();
	}
}
