package womobean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RedirectBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String goToPage(String page) {
		return page;
	}
}
