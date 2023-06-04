import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    
    public static void main(String[] args) throws Exception{
        MyService myService = new MyServiceImplementation();
        Registry registry = LocateRegistry.createRegistry(1080);
        registry.bind("MyService", myService);
        System.out.println("Server is running...");
    }
}
