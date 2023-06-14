import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        try {
            try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
                byte[] receiveData = new byte[1024];
                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);

                    String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Received from client: " + receivedMessage);

                    String responseMessage = "Response from server: " + receivedMessage;
                    byte[] sendData = responseMessage.getBytes();

                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();

                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

                    serverSocket.send(sendPacket);

                    receiveData = new byte[1024];
                }
            }
        } catch (SocketException e) {
            System.err.println("Server is shutting down...");
        } catch (Exception e) {
            System.err.println("An error occured in the server: " + e.getMessage());
        }
    }
}