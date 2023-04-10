import java.net.*;
import java.util.*;

public class ipNCCS {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter Domain Name: ");
            String ipAddress = input.next();
            try {
                InetAddress address = InetAddress.getByName(ipAddress);
                System.out.println(ipAddress + ": " + address.getHostAddress());
            } catch (Exception e) {
                System.out.println("Could not find IP address of: " + ipAddress);
            }
        }
    }
}