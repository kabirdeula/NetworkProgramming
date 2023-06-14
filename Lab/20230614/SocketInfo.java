import java.io.IOException;
import java.net.Socket;

public class SocketInfo {
    public static void main(String[] args) throws IOException{
        
        Socket socket = new Socket("localhost", 80);
        
        System.out.println("Connected to: " + socket.getInetAddress());
        System.out.println("Local Address: " + socket.getLocalAddress());
        System.out.println("Local Socket Address: " + socket.getLocalSocketAddress());

        System.out.println("Port: " + socket.getPort());
        System.out.println("Local Port: " + socket.getLocalPort());
        
    }
}
