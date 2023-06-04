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
