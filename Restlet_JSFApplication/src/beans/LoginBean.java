package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import womodao.KundenDAO;

@ManagedBean
@Named
@RequestScoped
public class LoginBean {
	@Inject
	KundenDAO kundenDAO;
	
	public String login(String vorname, String nachname, String strasse, String plz, String ort) {
        if (kundenDAO.findByParameters(vorname, nachname, strasse, plz, ort) != null) return "index2";
        return " ";
    }
}
