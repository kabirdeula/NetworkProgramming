import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    
    public static void main(String[] args) {
        try{
            InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
            int port = 8888;

            try (// Create a multicast socket
            MulticastSocket socket = new MulticastSocket(port)) {
                // Join the multicast group
                socket.joinGroup(groupAddress);

                System.out.println("Multicast Receiver Started. Listening for messages...");

                while (true) {
                    byte[] buffer = new byte[1024];

                    // Create a datagram packet for receiving data.
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    
                    // Receive the data
                    socket.receive(packet);

                    // Convert the received data to a string
                    String messageString = new String(packet.getData(), 0, packet.getLength());
                    
                    // Display the received message
                    System.out.println("Received message: " + messageString);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
