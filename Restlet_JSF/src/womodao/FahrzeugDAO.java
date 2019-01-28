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

@ManagedBean
@SessionScoped
public class FahrzeugDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	transient private WoMoService service;

	public List<Fahrzeug> findAll() {
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs");
		List<Fahrzeug> fahrzeuge = new ArrayList<>();
		for (Fahrzeug fahrzeug : query) {
			fahrzeuge.add(fahrzeug);
		}
		return fahrzeuge;
	}

	public Fahrzeug getById(int id) {
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs(" + id + ")");
		return query.iterator().next();
	}

	public boolean add(int fahrgestellNr, String marke, String typ, int standort) {
		try {
			Fahrzeug fahrzeug = new Fahrzeug();
			fahrzeug.setFahrgestellNr(fahrgestellNr);
			fahrzeug.setMarke(marke);
			fahrzeug.setTyp(typ);
			fahrzeug.setStandort_idstandort(standort);
			service.addEntity(fahrzeug);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Fahrzeug fahrzeug) {
		try {
			service.updateEntity(fahrzeug);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
