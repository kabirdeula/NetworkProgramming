# Lab 

|  S.N. |                                                                                           Topic                                                                                           |  Date  | Status |
| :---: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :----- | :----- |
| 1.    | [Looking up internet address of localhost.](#lab-1)                                                                                                                                       |        | Done   |
| 2.    | Implement the program whether the host is a spammer or not.                                                                                                                               |        | Done   |
| 3.    | [Implementation of port scanner.](#lab-3)                                                                                                                                                           |        | ToDo   |
| 4.    | [Implementing parts of URL.]()                                                                                                                                                                |        | ToDo   |
| 5.    | Encoding and Decoding URI.                                                                                                                                                                |        | ToDo   |
| 6.    | Retrieving data from URI.                                                                                                                                                                 |        | ToDo   |
| 7.    | Implementation of ping programming. (Testing Reachability is Reachable.)                                                                                                                  |        | ToDo   |
| 8.    | Implementing a list of all network interfaces on the localhost.                                                                                                                           |        | ToDo   |
| 9.    | Implementation of Client Server Communication using UDP.                                                                                                                                  |        | ToDo   |
| 10.   | Implementation of Client Server Communication using TCP.                                                                                                                                  |        | ToDo   |
| 11.   | Java multicast programming.                                                                                                                                                               |        | ToDo   |
| 12.   | Determining whether an IP address is IPv4 or IPv6.                                                                                                                                        |        | ToDo   |
| 13.   | Implmenting the characteristics of an IP address.                                                                                                                                         |        | ToDo   |
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