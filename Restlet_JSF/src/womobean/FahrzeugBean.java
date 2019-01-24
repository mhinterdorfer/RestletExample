package womobean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import womodao.FahrzeugDAO;
import womomodel.Fahrzeug;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class FahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	FahrzeugDAO dao;
	
	public List<Fahrzeug> getAll(){
		return dao.findAll();
	}

}
