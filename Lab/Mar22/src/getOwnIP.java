import java.net.*;

public class getOwnIP{
    public static void main(String[] args) throws UnknownHostException{
        try {
            InetAddress IPO = InetAddress.getLocalHost();
            System.out.println("IP of this system: " + IPO.getHostAddress());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}