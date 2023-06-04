## Lab 14

### Source Code

#### My Service

```java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {
    public String sayHello(String name) throws RemoteException;
}
```

#### My Service Implementation

```java
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
```

#### RMI Server

```java
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
```

#### RMIClient

```java
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost", 1080);
        MyService myService = (MyService) registry.lookup("MyService");
        String result = myService.sayHello("Kabir");
        System.out.println(result);
    }
}
```

### Output

```
Hello, Kabir!
```