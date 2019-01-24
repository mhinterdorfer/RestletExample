package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Kunde;

@Named
@SessionScoped
public class KundeDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	WoMoService service;
	
	public List<Kunde> findAll(){
		Query<Kunde> query = service.createKundeQuery("/Kundes");
		List<Kunde> kunden = new ArrayList<>();
		for(Kunde kunde : query) {
			kunden.add(kunde);
		}
		return kunden;
	}
}
