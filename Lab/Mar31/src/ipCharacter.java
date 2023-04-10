import java.net.*;
import java.util.Scanner;

public class ipCharacter {
    private InetAddress address;

    public ipCharacter(InetAddress address) {
        this.address = address;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ipCharacter) {
            ipCharacter other = (ipCharacter) obj;
            return this.address.equals(other.address);
        }
        return false;
    }

    public byte[] getAddress() {
        return this.address.getAddress();
    }

    public String getCanonicalHostName() {
        try {
            return this.address.getCanonicalHostName();
        } catch (Exception e) {
            return null;
        }
    }

    public static ipCharacter getLoopbackAddress() {
        return new ipCharacter(InetAddress.getLoopbackAddress());
    }

    public boolean isLoopbackAddress() {
        return this.address.isLoopbackAddress();
    }

    public boolean isAnyLocalAddress() {
        return this.address.isAnyLocalAddress();
    }

    public boolean isLinkLocalAddress() {
        return this.address.isLinkLocalAddress();
    }

    public boolean isSiteLocalAddress(){
        return this.address.isSiteLocalAddress();
    }
    public boolean isMulticastAddress() {
        return this.address.isMulticastAddress();
    }

    public boolean isMCGlobal() {
        return this.address.isMCGlobal();
    }

    public boolean isReachable(int timeout) {
        try {
            return this.address.isReachable(timeout);
        } catch (Exception e) {
            return false;
        }
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
                System.out.print("Enter IP address: ");
                String url = input.next();
                try {
                    InetAddress inetAddress = InetAddress.getByName(url);
                    ipCharacter myInetAddress = new ipCharacter(inetAddress);
                    System.out.println("Address for " + url + ": " + inetAddress.getHostAddress());
                    System.out.println("Canonical Host Name for " + url + ": " + inetAddress.getCanonicalHostName());
                    System.out.println("Loopback Address: " + ipCharacter.getLoopbackAddress().getAddress());

                    System.out.println(url + " is a loopback address: " + myInetAddress.isLoopbackAddress());
                    System.out.println(url + " is any local address: " + myInetAddress.isAnyLocalAddress());
                    System.out.println(url + " is a link local address: " + myInetAddress.isLinkLocalAddress());
                    System.out.println(url + " is a site local address: " + myInetAddress.isSiteLocalAddress());
                    System.out.println(url + " is a multicast address: " + myInetAddress.isMulticastAddress());
                    System.out.println(url + " is a globally scoped multicast address: " + myInetAddress.isMCGlobal());

                    System.out.println(url + " is reachable: " + myInetAddress.isReachable(5000));
                    System.out.println("Hash code for " + url + ": " + myInetAddress.hashCode());
                } catch (Exception e) {
                    System.out.println("Error getting InetAddress for " + url + ": " + e.getMessage());
                }
        }
    }
}
