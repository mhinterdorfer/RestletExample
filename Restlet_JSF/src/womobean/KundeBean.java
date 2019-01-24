package womobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.KundeDAO;
import womomodel.Fahrzeug_in_saison;
import womomodel.Kunde;

@Named
@SessionScoped
public class KundeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	KundeDAO dao;
	
	public List<Kunde> getAll(){
		return dao.findAll();
	}
	
	public Kunde getById(int id) {
		return dao.getById(id);
	}
	
	public Kunde findByParameters(String vn, String nn, String str, String plz, String ort) {
		return dao.findByParameters(vn, nn, str, plz, ort);
	}

}
