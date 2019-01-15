package beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.FahrzeugDAO;
import womomodel.Fahrzeug;

@ManagedBean
@Named
@RequestScoped
public class FahrzeugBean {

	@Inject
	FahrzeugDAO fahrzeugDAO;

	public Fahrzeug findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fahrzeug> getAll() {
		return fahrzeugDAO.findAll();
	}

	public void save(Fahrzeug t) {
		// TODO Auto-generated method stub

	}

}

