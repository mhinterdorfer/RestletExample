package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Kunde;
import womomodel.Mietfahrzeug;

@ManagedBean
@SessionScoped
public class MietfahrzeugDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	transient private WoMoService service;
	
	public List<Mietfahrzeug> findAll(){
		Query<Mietfahrzeug> query = service.createMietfahrzeugQuery("/Mietfahrzeugs");
		List<Mietfahrzeug> mietfahrzeuge = new ArrayList<>();
		for(Mietfahrzeug mietfahrzeug : query) {
			mietfahrzeuge.add(mietfahrzeug);
		}
		return mietfahrzeuge;
	}
	
	public Mietfahrzeug getById(int id) {
		Query<Mietfahrzeug> query = service.createMietfahrzeugQuery("/Mietfahrzeugs(" + id + ")");
		return query.iterator().next();
	}
}
