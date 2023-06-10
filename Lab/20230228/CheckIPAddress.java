import java.net.*;
import java.util.Scanner;

public class CheckIPAddress {
    public static void main(String[] args) {
        try {
            // Prompt the user to enter an IP address
            System.out.print("Enter an IP address: ");
            try (Scanner input = new Scanner(System.in)) {
                String ipAddress = input.next();

                // Get the InetAddress object for the IP address
                InetAddress inetAddress = InetAddress.getByName(ipAddress);

                // Check whether the InetAddress object is an IPv4 or IPv6 address
                if (inetAddress instanceof java.net.Inet4Address) {
                    System.out.println(ipAddress + " is an IPv4 address.");
                } else if (inetAddress instanceof java.net.Inet6Address) {
                    System.out.println(ipAddress + " is an IPv6 address.");
                } else {
                    System.out.println(ipAddress + " is not a valid IP address.");
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + e.getMessage());
        }
    }

}
