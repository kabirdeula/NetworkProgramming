import java.io.*;
import java.net.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream inputStream = null;

    public Server(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Server started.");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted.");

            inputStream = new DataInputStream(
                new BufferedInputStream(socket.getInputStream())
            );

            String line = " ";

            while (!line.equals("Over")) {
                try {
                    line = inputStream.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
            
            System.out.println("Closing connection.");
            
            socket.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Server(5000);
    }
}
