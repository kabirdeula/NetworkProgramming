import java.io.IOException;
import java.net.*;

public class ReachabilityTest {
    public static void main(String[] args) throws UnknownHostException, IOException {

        InetAddress address = InetAddress.getByName("www.facebook.com");
        System.out.println("Sending ping request to: " + address);

        if (address.isReachable(5000)) {
            System.out.println("Host is reachable.");
        } else {
            System.out.println("Host is not reachable.");
        }
    }
}
