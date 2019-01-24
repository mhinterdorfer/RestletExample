package womobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import womodao.MietfahrzeugDAO;
import womomodel.Mietfahrzeug;

@ManagedBean
@SessionScoped
public class MietfahrzeugBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	MietfahrzeugDAO dao;
	
	public List<Mietfahrzeug> getAll(){
		return dao.findAll();
	}

}
