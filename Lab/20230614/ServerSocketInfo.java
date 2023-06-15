import java.net.ServerSocket;

public class ServerSocketInfo {
    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(3310)) {
                System.out.println("Local Address: " + serverSocket.getInetAddress());
                System.out.println("Local Port: " + serverSocket.getLocalPort());
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
