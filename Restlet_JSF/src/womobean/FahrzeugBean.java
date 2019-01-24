package womobean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.FahrzeugDAO;
import womomodel.Fahrzeug;
import womomodel.Fahrzeug_in_saison;

import java.io.Serializable;

@Named
@SessionScoped
public class FahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	FahrzeugDAO dao;
	
	public List<Fahrzeug> getAll(){
		return dao.findAll();
	}
	
	public Fahrzeug getById(int id) {
		return dao.getById(id);
	}

}
