package womobean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RedirectBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String goToPage(String page) {
		return page;
	}

}
