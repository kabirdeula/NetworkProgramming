// import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        try {
            try (DatagramSocket clientSocket = new DatagramSocket()) {
                InetAddress serverAddress = InetAddress.getByName("localhost");
                int serverPort = 9876;

                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("'quit' to exit.");

                    while (true) {
                        System.out.print("Enter a message: ");
                        String message = scanner.nextLine();
                        byte[] sendData = message.getBytes();

                         if (message.equalsIgnoreCase("quit")) {
                            System.out.println("Client exiting...");
                            break;
                        }

                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                        clientSocket.send(sendPacket);

                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        clientSocket.receive(receivePacket);

                    }
                }
            }
        } catch (Exception e) {
            System.err.println("An error occured in the client: " + e.getMessage());
        }
    }
}