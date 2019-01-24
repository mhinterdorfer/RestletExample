package womobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.SaisonDAO;
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
	
	public Saison getById(int id) {
		return dao.getById(id);
	}

}
