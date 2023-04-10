import java.net.*;

public class determineIP {
    public static void main(String[] args) {

        String[] ipAddress = {
                "192.168.1.2",
                "2009:0000:1000:abc0:0000:1234:0000:0001"
        };

        for (String ip : ipAddress) {
            try {
                InetAddress address = InetAddress.getByName(ip);
                if (address instanceof java.net.Inet4Address) {
                    System.out.println(ip + " is an IPv4 address.");
                } else if (address instanceof java.net.Inet6Address) {
                    System.out.println(ip + " is an IPv6 address.");
                } else {
                    System.out.println(ip + " is not a valid IP address.");
                }
            } catch (UnknownHostException e) {
                System.err.println("Could not find IP address");
            }
        }
    }
}