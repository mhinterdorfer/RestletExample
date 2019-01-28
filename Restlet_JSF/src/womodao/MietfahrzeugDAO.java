package womodao;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Mietfahrzeug;

@ManagedBean
@SessionScoped
public class MietfahrzeugDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	transient private WoMoService service;

	public List<Mietfahrzeug> findAll() {
		Query<Mietfahrzeug> query = service.createMietfahrzeugQuery("/Mietfahrzeugs");
		List<Mietfahrzeug> mietfahrzeuge = new ArrayList<>();
		for (Mietfahrzeug mietfahrzeug : query) {
			mietfahrzeuge.add(mietfahrzeug);
		}
		return mietfahrzeuge;
	}

	public List<Mietfahrzeug> findAllFiltered(int id) {
		Query<Mietfahrzeug> query = service.createMietfahrzeugQuery("/Mietfahrzeugs")
				.filter("((idKunde eq " + id + "))");
		List<Mietfahrzeug> mietfahrzeuge = new ArrayList<>();
		for (Mietfahrzeug mietfahrzeug : query) {
			mietfahrzeuge.add(mietfahrzeug);
		}
		return mietfahrzeuge;
	}

	public Mietfahrzeug getById(int id) {
		Query<Mietfahrzeug> query = service.createMietfahrzeugQuery("/Mietfahrzeugs(" + id + ")");
		return query.iterator().next();
	}

	public boolean add(int fahrgestellNr, int kundenNr, int saison, Date datumVon, Date datumBis) {
		try {
			Mietfahrzeug mietfahrzeug = new Mietfahrzeug();
			mietfahrzeug.setFahrgestellNr(fahrgestellNr);
			mietfahrzeug.setIdKunde(kundenNr);
			mietfahrzeug.setIdSaison(saison);
			mietfahrzeug.setDatumVon(datumVon);
			mietfahrzeug.setDatumBis(datumBis);
			service.addEntity(mietfahrzeug);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(Mietfahrzeug edit) {
		try {
			service.updateEntity(edit);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
