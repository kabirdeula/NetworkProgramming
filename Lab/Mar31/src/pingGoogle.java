import java.io.IOException;
import java.net.*;

public class pingGoogle{
    public static void main(String[] args) throws UnknownHostException, IOException{
        InetAddress address = InetAddress.getByName("www.google.com");
        System.out.println("Sending ping request to: " + address);

        if(address.isReachable(5000)){
            System.out.println(address + " is reachable.");
        }else{
            System.out.println(address + " is not reachable");
        }

    }
}