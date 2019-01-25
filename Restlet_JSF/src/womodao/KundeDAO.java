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
	
	public Kunde findByParameters(String vn, String nn, String str, String plz, String ort) {
		try {
			Query<Kunde> query = service.createKundeQuery("/Kundes").filter("((vorname eq '" + vn + "') and (nachname eq '" + nn + "') and (strasse eq '" + str + "') and (plz eq " + plz + ") and (ort eq '" + ort + "'))");
			for(Kunde kunde : query) {
				return kunde;
			}
			return null;
		}catch(Exception ex) {
			return null;
		}
	}
}