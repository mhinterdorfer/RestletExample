package womobean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FormatBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String formatDate(Date date, String pattern) {
		System.out.println(date + " " + pattern);
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		System.out.println(format.format(date));
		return format.format(date);
	}
}
