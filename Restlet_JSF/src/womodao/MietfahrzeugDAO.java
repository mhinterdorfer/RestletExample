package womodao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.restlet.ext.odata.Query;

import service.WoMoService;
import womomodel.Mietfahrzeug;

@Named
@SessionScoped
public class MietfahrzeugDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject 
	WoMoService service;
	
	public List<Mietfahrzeug> findAll(){
		Query<Mietfahrzeug> query = service.createMietfahrzeugQuery("/Mietfahrzeugs");
		List<Mietfahrzeug> mietfahrzeuge = new ArrayList<>();
		for(Mietfahrzeug mietfahrzeug : query) {
			mietfahrzeuge.add(mietfahrzeug);
		}
		return mietfahrzeuge;
	}
}
