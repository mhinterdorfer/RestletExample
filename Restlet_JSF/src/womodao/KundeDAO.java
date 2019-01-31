package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Kunde;

@ManagedBean
@SessionScoped
public class KundeDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	transient private WoMoService service;

	public List<Kunde> findAll() {
		Query<Kunde> query = service.createKundeQuery("/Kundes");
		List<Kunde> kunden = new ArrayList<>();
		for (Kunde kunde : query) {
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
			Query<Kunde> query = service.createKundeQuery("/Kundes")
					.filter("((vorname eq '" + vn + "') and (nachname eq '" + nn + "') and (strasse eq '" + str
							+ "') and (plz eq " + plz + ") and (ort eq '" + ort + "'))");
			for (Kunde kunde : query) {
				return kunde;
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean add(String vorname, String nachname, String strasse, int plz, String ort) {
		try {
			Kunde kunde = new Kunde();
			kunde.setVorname(vorname);
			kunde.setNachname(nachname);
			kunde.setStrasse(strasse);
			kunde.setPlz(plz);
			kunde.setOrt(ort);
			service.addEntity(kunde);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean update(Kunde kunde) {
		try {
			service.updateEntity(kunde);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Kunde kunde) {
		try {
			service.deleteEntity(kunde);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
