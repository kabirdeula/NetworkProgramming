import java.net.*;
import java.util.Scanner;

public class MyInetAddress {
    private InetAddress address;

    public MyInetAddress(InetAddress address) {
        this.address = address;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MyInetAddress) {
            MyInetAddress other = (MyInetAddress) obj;
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

    public static MyInetAddress getLoopbackAddress() {
        return new MyInetAddress(InetAddress.getLoopbackAddress());
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
        try (// String[] urls = {"google.com", "javapoint.com", "facebook.com", "youtube.com", "224.10.243.12"};
                // String[] urls = {"127.0.1.0"};
        Scanner input = new Scanner(System.in)) {
            System.out.print("Enter IP address: ");
            String url = input.next();
            // for (String url : urls) {
                try {
                    InetAddress inetAddress = InetAddress.getByName(url);
                    MyInetAddress myInetAddress = new MyInetAddress(inetAddress);
                    System.out.println("Address for " + url + ": " + inetAddress.getHostAddress());
                    System.out.println("Canonical Host Name for " + url + ": " + inetAddress.getCanonicalHostName());
                    System.out.println("Loopback Address: " + MyInetAddress.getLoopbackAddress().getAddress());

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
            // }
        }
    }
}
