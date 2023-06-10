import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost", 1080);
        MyService myService = (MyService) registry.lookup("MyService");
        String result = myService.sayHello("John");
        System.out.println(result);
    }
}
