import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String sentence = new String(receivePacket.getData());
                InetAddress iPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                String capitalizedSentence = sentence.toUpperCase();
                sendData = capitalizedSentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, iPAddress, port);
                serverSocket.send(sendPacket);
            }
        }
    }
}