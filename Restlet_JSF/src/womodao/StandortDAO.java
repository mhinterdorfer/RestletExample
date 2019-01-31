package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Standort;

@ManagedBean
@SessionScoped
public class StandortDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	transient private WoMoService service;

	public List<Standort> findAll() {
		Query<Standort> query = service.createStandortQuery("/Standorts");
		List<Standort> standorte = new ArrayList<>();
		for (Standort standort : query) {
			standorte.add(standort);
		}
		return standorte;
	}

	public Standort getById(int id) {
		Query<Standort> query = service.createStandortQuery("/Standorts(" + id + ")");
		return query.iterator().next();
	}

	public boolean add(int standortNr, String bezeichnung, String strasse, int plz, String ort) {
		try {
			Standort standort = new Standort();
			standort.setIdStandort(standortNr);
			standort.setBezeichnung(bezeichnung);
			standort.setStrasse(strasse);
			standort.setPlz(plz);
			standort.setOrt(ort);
			service.addEntity(standort);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(Standort edit) {
		try {
			service.updateEntity(edit);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Standort standort) {
		try {
			service.deleteEntity(standort);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
