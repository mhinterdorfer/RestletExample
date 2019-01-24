package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Saison;

@Named
@SessionScoped
public class SaisonDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	transient private WoMoService service;
	
	public List<Saison> findAll(){
		Query<Saison> query = service.createSaisonQuery("/Saisons");
		List<Saison> saisons = new ArrayList<>();
		for(Saison saison : query) {
			saisons.add(saison);
		}
		return saisons;
	}
	
	public Saison getById(int id) {
		Query<Saison> query = service.createSaisonQuery("/Saisons(" + id + ")");
		return query.iterator().next();
	}
}
