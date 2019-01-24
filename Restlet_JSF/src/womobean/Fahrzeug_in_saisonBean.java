package womobean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import womodao.Fahrzeug_in_saisonDAO;
import womomodel.Fahrzeug_in_saison;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Fahrzeug_in_saisonBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	Fahrzeug_in_saisonDAO dao;

	public List<Fahrzeug_in_saison> getAll() {
		return dao.findAll();
	}
}
