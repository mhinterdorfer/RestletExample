package womobean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class RedirectBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String goToPage(String page) {
		return page;
	}
	
	public void goToPageXHTML(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
