package womodao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoServiceService;
import womomodel.Fahrzeug;
import womomodel.Kunde;

@Named
@RequestScoped
public class KundenDAO {
	@Inject 
	WoMoServiceService service;
	
	public List<Kunde> findAll(){
		Query<Kunde> query = service.createKundeQuery("/Kundes");
		List<Kunde> kunden = new ArrayList<>();
		for(Kunde kunde : query) {
			kunden.add(kunde);
		}
		return kunden;
	}
	
	public Kunde findByParameters(String vn, String nn, String str, String plz, String ort) {
		Query<Kunde> query = service.createKundeQuery("/Kundes").filter("((vorname eq '" + vn + "') and (nachname eq '" + nn + "') and (strasse eq '" + str + "') and (plz eq " + plz + ") and (ort eq '" + ort + "'))");
		for(Kunde kunde : query) {
			return kunde;
		}
		return null;
	}
}
