import java.io.IOException;
import java.net.ServerSocket;

public class PortListener {
    public static void main(String[] args) {
        for (int i = 1; i < 65535; i++) {
            try {
                ServerSocket server = new ServerSocket(i);
                server.close();
            } catch (IOException e) {
                System.out.println("There is server port on: " + i);
            }
        }
    }
}
