package womobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import womodao.StandortDAO;
import womomodel.Standort;

@ManagedBean
@SessionScoped
public class StandortBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	StandortDAO dao;
	
	public List<Standort> getAll(){
		return dao.findAll();
	}

}
