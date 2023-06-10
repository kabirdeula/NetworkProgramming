# Lab 

|  S.N. |                                                                                           Topic                                                                                                      |  Date  | Status |
| :---: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :----- | :----- |
| 1.    | [Looking up internet address of localhost.](#lab-1)                                                                                                                                                  |        | Done   |
| 2.    | [Implement the program whether the host is a spammer or not.](#lab-2)                                                                                                                                |        | Done   |
| 3.    | [Implementation of port scanner.](#lab-3)                                                                                                                                                            |        | Done   |
| 4.    | [Implementing parts of URL.](#lab-4)                                                                                                                                                                 |        | Done   |
| 5.    | [Encoding and Decoding URI.](#lab-5)                                                                                                                                                                 |        | Done   |
| 6.    | [Retrieving data from URI.](#lab-6)                                                                                                                                                                  |        | Done   |
| 7.    | [Implementation of ping programming. (Testing Reachability is Reachable.)](#lab-7)                                                                                                                   |        | Done   |
| 8.    | [Implementing a list of all network interfaces on the localhost.](#lab-8)                                                                                                                            |        | Done   |
| 9.    | [Determining whether an IP address is IPv4 or IPv6.](#lab-9)                                                                                                                                         |        | Done   |
| 10.   | [Implmenting the characteristics of an IP address.](#lab-10)                                                                                                                                         |        | Done   |
| 11.   | [Develop a program to print the HTTP header.](#lab-11)                                                                                                                                               |        | Done   |
| 12.   | [Develop a program to create a TCP server and client in which the server provides factorial calculation service whereas the client simply requests to calculate the factorial of a number.](#lab-12) |        | ToDo   |
| 13.   | [Java multicast programming.](#lab-13)                                                                                                                                                               |        | ToDo   |
| 14.   | [Implementing RMI Service Interface.](#lab-14)                                                                                                                                                                  |        | ToDo   |
| 15.   | Implementation of Client Server Communication using UDP.                                                                                                                                             |        | ToDo   |
| 16.   | Implementation of Client Server Communication using TCP.                                                                                                                                             |        | ToDo   |
| 17.   | Implementation of Authenticator Class.                                                                                                                                                               |        | ToDo   |
| 18.   | Implementation of Proxy Class and The ProxySelector CLass.                                                                                                                                           |        | ToDo   |
| 19.   | Getting information about a Socket.                                                                                                                                                                  |        | ToDo   |
| 20.   | Getting information about a ServerSocket.                                                                                                                                                            |        | ToDo   |
| 21.   | Implementation of Whois Server.                                                                                                                                                                      |        | ToDo   |
| 22.   | Implementating ports on the local machine by using ServerSocket objects.                                                                                                                             |        | ToDo   |
| 23.   | Implementation of Socket program for the UDP Echo Client and Echo Server.                                                                                                                            |        | ToDo   |
| 24.   | Implementing the name of multicast group.                                                                                                                                                            |        | ToDo   |
| 25.   | Develop a program to perform basic text messaging between the client and server using UDP.                                                                                                           |        | ToDo   |
| 26.   | Develop a program to create a TCP client and server socket to communicate using a simple two-way text message.                                                                                       |        | ToDo   |
| 27.   | Program to show any cookie information stored in your system.                                                                                                                                        |        | ToDo   |

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

[Go to Top](#lab)

[Main File](/Lab/20230322/GetOwnIP.java)

## Lab 2

### Source Code

```java

import java.net.*;
public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";
    public static void main(String[] args) throws UnknownHostException{
        for(String arg: args){
            if(isSpammer(arg)){
                System.out.println(arg + " is a known spammer.");
            } else{
                System.out.println(arg + " appears legitimate.");
            }
        }
    }
    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for(byte octet : quad){
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
```

### Output

```
java SpamCheck 114.254.94.185
114.254.94.185 is a known spammer.
```

[Go to Top](#lab)

[Main File](/Lab/20230302/SpamCheck.java)

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

[Go to Top](#lab)

[Main File](/Lab/20230322/PortScanner.java)

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

[Go to Top](#lab)

[Main File](/Lab/20230313/URLinfo.java)

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

[Go to Top](#lab)

[Main File](/Lab/20230317/URIDemo.java)

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

[Go to Top](#lab)

[Main File](/Lab/20230317/URIData.java)

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

[Go to Top](#lab)

[Main File](/Lab/20230327/ReachabilityTest.java)

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
name:br-971a1b0bc169 (br-971a1b0bc169)
name:docker0 (docker0)
name:wlp2s0 (wlp2s0)
name:lo (lo)
```

[Go to Top](#lab)

[Main File](/Lab/20230301/InterfaceLister.java)

## Lab 9

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

[Go to Top](#lab)

[Main File](/Lab/20230228/CheckIPAddress.java)

## Lab 10

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

[Go to Top](#lab)

[Main File](/Lab/20230228/MyInetAddress.java)

## Lab 11

### Source Code

```java
import java.net.*;
// import java.io.*;

public class HTTPHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://kabirdeula.info.np/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            for (int i = 1; ; i++) {
                String headerName = connection.getHeaderFieldKey(i);
                String headerValue = connection.getHeaderField(i);
                if (headerName == null && headerValue == null) {
                    break;
                }
                System.out.println(headerName + ": " + headerValue);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.err.println(e);
        }
    }    
}
```

### Output

```
Accept-Ranges: bytes
Age: 2
Cache-Control: public, max-age=0, must-revalidate
Content-Length: 16974
Content-Type: text/html; charset=UTF-8
Date: Tue, 11 Apr 2023 12:36:54 GMT
Etag: "2badc71ffb96b61af9df3563b2b9f2f8-ssl"
Server: Netlify
Strict-Transport-Security: max-age=31536000
X-Nf-Request-Id: 01GXR53C2FYT5A5V32SR112P9D
```

[Go to Top](#lab)

[Main File](/Lab/20230326/HTTPHeader.java)

## Lab 12

### Source Code

#### Server

```java
import java.io.*;
import java.net.*;

class Server{
    public static void main(String[] args) {
        try{
            int port = 8001;

            // Creating a server
            ServerSocket server = new ServerSocket(port);
            
            // getting ip address of the server
            InetAddress address = InetAddress.getLocalHost();

            System.out.println("Waiting for connection" + "\nHost IP: " + address.getHostAddress() + "\nPort: " + port);

            // Accepting client connection    
            Socket socket = server.accept();

            System.out.println("Connection type: TCP\n" + "Connection Established");

            // Creating input/output stream for writing data to client or reading the data from client.
            PrintStream printStream = new PrintStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String strRequest, strResponse = null;

                while ((strRequest = bufferedReader.readLine()) != null) {
                    System.out.println("Client :: " + strRequest);
                    if (strRequest.startsWith("/")) {
                        // custom commands
                        if (strRequest.startsWith("/fact")) {
                            int num = Integer.parseInt(strRequest.split(" ", 2)[1]);
                            int fact = 1;
                            for (int i = 1; i <= num; i++) {
                                fact *= i;
                            }

                            strResponse = "Factorial of " + num + " is " + fact;
                        }
                    }else{
                        System.out.println("Server :: ");
                        strResponse = bufferedReader2.readLine();
                    }
                    printStream.println(strResponse);
                }
                printStream.close();
                bufferedReader.close();
                bufferedReader2.close();
                server.close();
                socket.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

#### Client

```java
import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
    public static void main(String[] args) {
        try {
            try (
                // Reading Host IP address and port given by the user.
            Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter host address: ");
                String host = scanner.nextLine();
                System.out.print("Enter port address: ");
                int port = Integer.parseInt(scanner.nextLine());

                // Connecting to socket using host and port provided by user.
                Socket socket = new Socket(host, port);
                System.out.println("Connection to server accepted.");

                // I/o stream to read and write data
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

                String strRequest, strResponse;
                System.out.println("/'quit/' to exit");
                while (!(strRequest = bufferedReader2.readLine()).equals("quit")) {
                    // dataOutputStream to write to the server.
                    dataOutputStream.writeBytes(strRequest + "\n");
                    strResponse = bufferedReader.readLine();
                    System.out.print("Server: " + strResponse);
                    System.out.print("Client: ");
                }
                dataOutputStream.close();
                bufferedReader.close();
                bufferedReader2.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

### Output

Server Side
```
Waiting for connection
Host IP: 127.0.1.1
Port: 8001
Connection type: TCP
Connection Established
Client: accessing server
Server: server accessed
```

Client Side
```
Enter host address: 127.0.1.1
Enter port address: 8001
Connection to server accepted.
'quit' to exit
accessing server
Server: server accessed
Client: /fact 7
Server: Factorial of 7 is 5040
Client: quit
```

[Go to Top](#lab)

[Main File](/Lab/20230403/)

## Lab 13

### Source Code

#### Multicast Receiver

```java
import java.io.IOException;
import java.net.*;

public class MulticastReceiver{

    public static void main(String[] args){
        try{
            // Mulicast group address
            InetAddress group = InetAddress.getByName("224.0.0.1");
            // Multicast group port
            int port = 8888;

            // Create a multicast group
            MulticastSocket socket = new MulticastSocket(port);
            
            // Join the multicast group
            socket.joinGroup(group);

            System.out.println("Multicast Receiver Started. Listening for messages...");

            while(true){
                byte[] buffer = new byte[1024];

                // Create a datagram packet for receiving data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Receiver the data
                socket.receive(packet);

                // Convert the received data to a string
                String messageString = new String(packet.getData(), 0, packet.getLength());

                // Display the received message
                System.out.println("Received message: " + messageString);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
```

#### Multicast Sender

```java
import java.io.IOException;
import java.net.*;

public class MulticastSender{
    public static void main(String[] args){
        try{
            // Mulicast group address
            InetAddress group = InetAddress.getByName("224.0.0.1");
            // Multicast group port
            int port = 8888;

            // Create a datagram socket
            DatagramSocket socket = new DatagramSocket();

            System.out.println("Multicast Sender Started.\nEnter messages to send.\nEnter 'exit' to quit");

            while(true){

                // Read input from the user
                System.out.println("Message sent: ");
                String message = getUserInput();

                // Check if user wants to exit
                if(message.equalsIgnoreCase("exit")){
                    break;
                }

                // Convert the message to bytes
                byte[] buffer = message.getBytes();

                // Create a datagram for reading data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length,group, port);

                // Send the packet
                socket.send(packet);

            }

            // Close the socket
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String getUserInput() throws IOException{
        byte[] buffer = new byte[1024];
        System.in.read(buffer);

        return new String(buffer).trim();
    }
}
```

### Output

Receiver
```
Multicast Receiver Started. Lisening for messages...
Received message: Hello World!!
Received message: Bye World!
```

Sender
```
Multicast Sender Started.
Enter messages to send.
Enter 'exit' to quit
Message sent: Hello World!
Message sent: Bye World!
Message sent: exit
```

[Go to Top](#lab)

[Main File](/Lab/20230601/)

## Lab 14

### Source Code

#### My Service

```java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyService extends Remote {
    public String sayHello(String name) throws RemoteException;
}
```

#### My Service Implementation

```java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServiceImplementation extends UnicastRemoteObject implements MyService{
    public MyServiceImplementation() throws RemoteException{
        super();
    }

    public String sayHello(String name) throws RemoteException{
        return "Hello, " + name + "!";
    }
}
```

#### RMI Server

```java
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    
    public static void main(String[] args) throws Exception{
        MyService myService = new MyServiceImplementation();
        Registry registry = LocateRegistry.createRegistry(1080);
        registry.bind("MyService", myService);
        System.out.println("Server is running...");
    }
}
```

#### RMIClient

```java
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception{
        Registry registry = LocateRegistry.getRegistry("localhost", 1080);
        MyService myService = (MyService) registry.lookup("MyService");
        String result = myService.sayHello("Kabir");
        System.out.println(result);
    }
}
```

### Output

```
Hello, Kabir!
```

[Go to Top](#lab)

[Main File](/Lab/20230603/)
