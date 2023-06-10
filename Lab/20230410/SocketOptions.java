import java.io.*;
import java.net.*;

public class SocketOptions {
    
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        
        // set TCP_NODELAY option to true
        socket.setTcpNoDelay(true);
        
        // set SO_BINDADDR option to false
        socket.setReuseAddress(false);
        
        // set SO_TIMEOUT option to 10 seconds
        socket.setSoTimeout(10000);
        
        // set SO_LINGER option to 0 seconds
        socket.setSoLinger(true, 0);
        
        // set SO_SNDBUF option to 64 KB
        socket.setSendBufferSize(64 * 1024);
        
        // set SO_RCVBUF option to 64 KB
        socket.setReceiveBufferSize(64 * 1024);
        
        // set SO_KEEPALIVE option to true
        socket.setKeepAlive(true);
        
        // connect to a server
        socket.connect(new InetSocketAddress("localhost", 8080));
        
        // send a message to the server
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream));
        out.println("Hello, server!");
        out.flush();
        
        // receive a message from the server
        InputStream inputStream = socket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String response = in.readLine();
        System.out.println("Server response: " + response);
        
        // close the socket
        socket.close();
    }

}
