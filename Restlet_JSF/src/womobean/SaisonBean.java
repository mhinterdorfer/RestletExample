package womobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import womodao.SaisonDAO;
import womomodel.Saison;

@ManagedBean
@SessionScoped
public class SaisonBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	SaisonDAO dao;
	
	public List<Saison> getAll(){
		return dao.findAll();
	}

}
