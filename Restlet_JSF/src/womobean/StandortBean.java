package womobean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.StandortDAO;
import womomodel.Fahrzeug_in_saison;
import womomodel.Standort;

@Named
@SessionScoped
public class StandortBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	StandortDAO dao;
	
	public List<Standort> getAll(){
		return dao.findAll();
	}
	
	public HashMap<String, Integer> getAllDropdown(){
		HashMap<String, Integer> standorte = new HashMap<String, Integer>();
		for(Standort standort : dao.findAll()) {
			standorte.put(standort.getBezeichnung(), standort.getIdStandort());
		}
        return standorte;
	}
	
	public Standort getById(int id) {
		return dao.getById(id);
	}

}
