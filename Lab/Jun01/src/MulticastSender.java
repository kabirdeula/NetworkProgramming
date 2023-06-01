import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.0.0.1");
            int port = 8888;

            // Create a datagram socket
            DatagramSocket socket = new DatagramSocket();

            System.out.println("Multicast Sender Started.\nEnter messages to send.\nEnter 'exit' to quit");

            while (true) {
                // Read input from the user
                System.out.print("Message sent: ");
                String message = getUserInput();

                // Check if user wants to exit
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                // Convert the message to bytes.
                byte[] buffer = message.getBytes();

                // Create a datagram for sending data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);

                // Send the packet
                socket.send(packet);

            }

            // Close the socket
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput() throws IOException{
        byte[] buffer = new byte[1024];
        System.in.read(buffer);

        return new String(buffer).trim();
        
    }
}
