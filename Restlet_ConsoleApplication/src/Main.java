import org.restlet.ext.odata.*;

public class Main {

	public static void main(String[] args) {
		Generator generator = new Generator("http://localhost:51375/Service1.svc");
        
        try {
            generator.generate("./src/");
        }catch(Exception x) {
            System.out.println(x);
        }

	}

}
