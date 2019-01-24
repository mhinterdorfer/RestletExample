package womobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import womodao.KundeDAO;
import womomodel.Kunde;

@ManagedBean
@SessionScoped
public class KundeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	KundeDAO dao;
	
	public List<Kunde> getAll(){
		return dao.findAll();
	}

}
