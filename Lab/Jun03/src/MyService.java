import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {
    public String sayHello(String name) throws RemoteException;
}
