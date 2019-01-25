package womobean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womomodel.Kunde;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	KundeBean kundeBean;

	@Inject
	RedirectBean redirectBean;

	String message = "";
	Integer kundenNR = null;

	public void login(String vorname, String nachname, String strasse, String plz, String ort) {
		if (vorname.equals("admin")) {
			redirectBean.goToPageXHTML("home.xhtml");
		} else if (!vorname.equals("") || !nachname.equals("") || !strasse.equals("") || !plz.equals("")
				|| ort.equals("")) {
			Kunde kunde = kundeBean.findByParameters(vorname, nachname, strasse, plz, ort);
			if (kunde != null) {
				kundenNR = kunde.getIdKunde();
				redirectBean.goToPageXHTML("home.xhtml");
			}
		}
		setMessage("Login fehlgeschlagen.");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println(message);
		this.message = message;
	}

	public Integer getKundenNR() {
		return kundenNR;
	}

	public void setKundenNR(Integer kundenNR) {
		this.kundenNR = kundenNR;
	}

	public void logout() {
		this.kundenNR = null;
		this.message = "";
		redirectBean.goToPageXHTML("login.xhtml");
	}
}
