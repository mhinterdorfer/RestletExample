package womodao;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

	public List<Saison> findAll() {
		Query<Saison> query = service.createSaisonQuery("/Saisons");
		List<Saison> saisons = new ArrayList<>();
		for (Saison saison : query) {
			saisons.add(saison);
		}
		return saisons;
	}

	public Saison getById(int id) {
		Query<Saison> query = service.createSaisonQuery("/Saisons(" + id + ")");
		return query.iterator().next();
	}

	public boolean add(int saisonNr, String name, Date datumVon, Date datumBis) {
		try {
			Saison saison = new Saison();
			saison.setIdSaison(saisonNr);
			saison.setName(name);
			saison.setDatumVon(datumVon);
			saison.setDatumBis(datumBis);
			service.addEntity(saison);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(Saison edit) {
		try {
			service.updateEntity(edit);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Saison saison) {
		try {
			service.deleteEntity(saison);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
