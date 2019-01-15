import org.restlet.ext.odata.*;

public class Main {

	public static void main(String[] args) {
		//generateFromService();

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
