# Lab 

|  S.N. |                                                                                           Topic                                                                                           |  Date  | Status |
| :---: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :----- | :----- |
| 1.    | [Looking up internet address of localhost.](#lab-1)                                                                                                                                       |        | Done   |
| 2.    | Implement the program whether the host is a spammer or not.                                                                                                                               |        | ToDo   |
| 3.    | [Implementation of port scanner.](#lab-3)                                                                                                                                                 |        | Done   |
| 4.    | [Implementing parts of URL.](#lab-4)                                                                                                                                                      |        | Done   |
| 5.    | [Encoding and Decoding URI.](#lab-5)                                                                                                                                                      |        | ToDo   |
| 6.    | [Retrieving data from URI.](#lab-6)                                                                                                                                                       |        | ToDo   |
| 7.    | [Implementation of ping programming. (Testing Reachability is Reachable.)](#lab-7)                                                                                                        |        | Done   |
| 8.    | [Implementing a list of all network interfaces on the localhost.](#lab-8)                                                                                                                 |        | Done   |
| 9.    | Implementation of Client Server Communication using UDP.                                                                                                                                  |        | ToDo   |
| 10.   | Implementation of Client Server Communication using TCP.                                                                                                                                  |        | ToDo   |
| 11.   | Java multicast programming.                                                                                                                                                               |        | ToDo   |
| 12.   | [Determining whether an IP address is IPv4 or IPv6.](#lab-12)                                                                                                                             |        | ToDo   |
| 13.   | [Implmenting the characteristics of an IP address.](#lab-13)                                                                                                                                         |        | ToDo   |
| 14.   | Implementation of Authenticator Class.                                                                                                                                                    |        | ToDo   |
| 15.   | Implementation of Proxy Class and The ProxySelector CLass.                                                                                                                                |        | ToDo   |
| 16.   | Develop a program to print the HTTP header.                                                                                                                                               |        | ToDo   |
| 17.   | Getting information about a Socket.                                                                                                                                                       |        | ToDo   |
| 18.   | Getting information about a ServerSocket.                                                                                                                                                 |        | ToDo   |
| 19.   | Implementation of Whois Server.                                                                                                                                                           |        | ToDo   |
| 20.   | Implementating ports on the local machine by using ServerSocket objects.                                                                                                                  |        | ToDo   |
| 21.   | Implementation of Socket program for the UDP Echo Client and Echo Server.                                                                                                                 |        | ToDo   |
| 22.   | Implementing the name of multicast group.                                                                                                                                                 |        | ToDo   |
| 23.   | Implementing RMI Service Interface.                                                                                                                                                       |        | ToDo   |
| 24.   | Develop a program to perform basic text messaging between the client and server using UDP.                                                                                                |        | ToDo   |
| 25.   | Develop a program to create a TCP client and server socket to communicate using a simple two-way text message.                                                                            |        | ToDo   |
| 26.   | Develop a program to create a UDP server and client in which the server provides factorial calculation service whereas the client simply requests to calculate the factorial of a number. |        | ToDo   |
| 27.   | Program to show any cookie information stored in your system.                                                                                                                             |        | ToDo   |

## Lab 1

### Source Code

```java
import java.util.*;
import java.lang.*;
import java.net.*;

public class getOwnIP{
    public static void main(String[] args) throws UnknownHostException {
        try {
            InetAddress IPO = InetAddress.getLocalHost();
            System.out.println("IP of this system: " + IPO.getHostAddress());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

### Output

```
IP of this system: 10.1.60.11
```

## Lab 3

### Source Code

```java

import java.net.*;

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost";
        int minPort = 1;
        int maxPort = 65535;

        try {
            InetAddress inetAddress = InetAddress.getByName(host);

            for (int port = minPort; port <= maxPort; port++) {
                try (Socket socket = new Socket()) {
                    socket.connect(new InetSocketAddress(inetAddress, port), 1000);
                    System.out.println("Port " + port + " is open");
                } catch (Exception e) {
                    // System.out.println("Connection is closed.");
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + host);
        }
    }
}

```

### Output

```
Port 21 is open
Port 80 is open
Port 2821 is open
Port 3306 is open
Port 47616 is open
Port 58888 is open
Port 59806 is open
```

## Lab 4

### Source Code

```java
import java.net.*;

public class URLinfo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java URLInfo <url>");
            System.exit(1);
        }
        try {
            URL url = new URL("https://www.tutorialspoint.com/javaexamples/net_singleuser.htm");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("File: " + url.getFile());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Default Port: " + url.getDefaultPort());
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + args[0]);
        }
    }
}

```

### Output

```
Protocol: https
Host: www.tutorialspoint.com
Port: -1
File: /javaexamples/net_singleuser.htm
Authority: www.tutorialspoint.com
Query: null
Default Port: 443
```

## Lab 5

### Source Code

```java
import java.net.URLEncoder;
import java.util.Scanner;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class URIDemo {
    public static void main(String[] args) {
        String encodedURI = null;
        String decodedURI = null;
        String charset = "UTF-8"; // the character encoding to be used for encoding/decoding

        String originalURI;

        try (Scanner inputScanner = new Scanner(System.in)) {
            System.out.print("Enter your URI: ");
            originalURI = inputScanner.next();
        }
        
        // Encoding the URI
        try {
            encodedURI = URLEncoder.encode(originalURI, charset);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error encoding URI: " + e.getMessage());
        }
        System.out.println("Encoded URI: " + encodedURI);

        // Decoding the URI
        try {
            decodedURI = URLDecoder.decode(encodedURI, charset);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error decoding URI: " + e.getMessage());
        }
        System.out.println("Decoded URI: " + decodedURI);
    }
}
```

### Output

```
Enter your URI: www.facebook.com/profile?kabirdeula=1
Encoded URI: www.facebook.com%2Fprofile%3Fkabirdeula%3D1
Decoded URI: www.facebook.com/profile?kabirdeula=1
```

## Lab 6

### Source Code

```java
import java.net.*;
import java.io.*;

public class URIData {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://animechan.vercel.app/api/random");
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("GET");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        System.out.println(response.toString());
        
        connection.disconnect();
    }
}

```

### Output

```
{"anime":"Noragami","character":"Bishamonten","quote":"If you hurt me, then so be it. Do you think that there is any human in all the world who has never hurt another? You are all so kind...It hurts you to hurt others. That is why I had been hiding my pain, as well."}
```

## Lab 7

### Source Code

```java
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
```

### Output

```
Sending ping request to: www.facebook.com/157.240.7.35
Host is reachable.
```

## Lab 8

### Source Code

```java
import java.net.*;
import java.util.*;

public class InterfaceLister {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
    }
}
```

### Output

```
name:lo (lo)
```

## Lab 12

### Source Code

```java
import java.net.*;
import java.util.Scanner;

public class CheckIP {
    public static void main(String[] args) {
        try {
            System.out.print("Enter an IP address: ");
            try (Scanner input = new Scanner(System.in)) {
                String ipAddress = input.next();
                InetAddress inetAddress = InetAddress.getByName(ipAddress);
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

```

### Output

```
Enter an IP address: 192.168.1.1
192.168.1.1 is an IPv4 address.

Enter an IP address: abcd:0000:1234:5678:90ab:cdef:ffff:9876
abcd:0000:1234:5678:90ab:cdef:ffff:9876 is an IPv6 address.
```

## Lab 13

### Source Code

```java
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
        try (Scanner input = new Scanner(System.in)) {
                System.out.print("Enter IP address: ");
                String url = input.next();
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
        }
    }
}

```

### Output

```
Enter IP address: nccs.edu.np
Address for nccs.edu.np: 216.194.166.204
Canonical Host Name for nccs.edu.np: ded4135.inmotionhosting.com
Loopback Address: [B@7d4991ad
nccs.edu.np is a loopback address: false
nccs.edu.np is any local address: false
nccs.edu.np is a link local address: false
nccs.edu.np is a site local address: false
nccs.edu.np is a multicast address: false
nccs.edu.np is a globally scoped multicast address: false
nccs.edu.np is reachable: false
Hash code for nccs.edu.np: -658331956z
```