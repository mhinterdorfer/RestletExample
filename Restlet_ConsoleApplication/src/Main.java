import org.restlet.ext.odata.*;

import womomodel.Fahrzeug;

public class Main {

	public static void main(String[] args) {
		//generateFromService();
		WoMoServiceService service = new WoMoServiceService();
		Query<Fahrzeug> query = service.createFahrzeugQuery("/Fahrzeugs");
		for(Fahrzeug fahrzeug : query) {
			System.out.println("Fahrzeugmarke: " + fahrzeug.getMarke());
		}
	}
	
	private static void generateFromService() {
		Generator generator = new Generator("http://localhost:50021/WoMoService.svc/");
        
        try {
            generator.generate("./src/");
        }catch(Exception x) {
            System.out.println(x);
        }
	}

}
