package womobean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.SaisonDAO;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;
import womomodel.Saison;

@Named
@SessionScoped
public class SaisonBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	SaisonDAO dao;
	
	public List<Saison> getAll(){
		return dao.findAll();
	}
	
	public HashMap<String, Integer> getAllDropdown(){
		HashMap<String, Integer> saisonen = new HashMap<String, Integer>();
		for(Saison saison : dao.findAll()) {
			saisonen.put(saison.getName(), saison.getIdSaison());
		}
        return saisonen;
	}
	
	public Saison getById(int id) {
		return dao.getById(id);
	}

}
