package beans;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import womodao.KundenDAO;

@ManagedBean
@Named
@SessionScoped
public class LoginBean {
	@Inject
	KundenDAO kundenDAO;
	
	String message = "";
	Integer kundenNR = null;
	
	public String login(String vorname, String nachname, String strasse, String plz, String ort) {
        if (vorname.equals("admin")) {
        	return "login_admin";
        }else if(kundenDAO.findByParameters(vorname, nachname, strasse, plz, ort) != null) {
        	kundenNR = kundenDAO.findByParameters(vorname, nachname, strasse, plz, ort).getIdKunde();
        	return "login_kunde";
        }else {
        	setMessage("Login fehlgeschlagen.");
        	return "";
        }
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println(message);
		this.message = message;
	}
	
	public String logout() {
		kundenNR = null;
		return "logout";
	}

}
