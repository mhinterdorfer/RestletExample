package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Fahrzeug_in_saison;
import womomodel.Kunde;

@ManagedBean
@SessionScoped
public class KundeDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	transient private WoMoService service;
	
	public List<Kunde> findAll(){
		Query<Kunde> query = service.createKundeQuery("/Kundes");
		List<Kunde> kunden = new ArrayList<>();
		for(Kunde kunde : query) {
			kunden.add(kunde);
		}
		return kunden;
	}
	
	public Kunde getById(int id) {
		Query<Kunde> query = service.createKundeQuery("/Kundes(" + id + ")");
		return query.iterator().next();
	}
}
