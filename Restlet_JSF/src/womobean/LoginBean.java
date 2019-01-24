package womobean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
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

	public String login(String vorname, String nachname, String strasse, String plz, String ort) {
		if (vorname.equals("admin")) {
			return redirectBean.goToPage("login");
		} else if (!vorname.equals("") || !nachname.equals("") || !strasse.equals("") || !plz.equals("") || ort.equals("")) {
			Kunde kunde = kundeBean.findByParameters(vorname, nachname, strasse, plz, ort);
			if(kunde != null) {
				kundenNR = kunde.getIdKunde();
				return redirectBean.goToPage("login");
			}
		}
		setMessage("Login fehlgeschlagen.");
		return "";
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
		return redirectBean.goToPage("logout");
	}
}
