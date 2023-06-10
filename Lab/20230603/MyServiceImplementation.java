import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServiceImplementation extends UnicastRemoteObject implements MyService{
    public MyServiceImplementation() throws RemoteException{
        super();
    }

    public String sayHello(String name) throws RemoteException{
        return "Hello, " + name + "!";
    }
}
