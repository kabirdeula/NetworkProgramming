import java.io.*;
import java.net.*;

class Server{
    public static void main(String[] args) {
        try{
            int port = 7001;

            // Creating a server
            ServerSocket server = new ServerSocket(port);
            
            // getting ip address of the server
            InetAddress address = InetAddress.getLocalHost();

            System.out.println("Waiting for connection" + "\nHost IP: " + address.getHostAddress() + "\nPort: " + port);

            // Accepting client connection    
            Socket socket = server.accept();

            System.out.println("Connection type: TCP\n" + "Connection Established");

            // Creating input/output stream for writing data to client or reading the data from client.
            PrintStream printStream = new PrintStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String strRequest, strResponse = null;

                while ((strRequest = bufferedReader.readLine()) != null) {
                    System.out.println("Client :: " + strRequest);
                    if (strRequest.startsWith("/")) {
                        // custom commands
                        if (strRequest.startsWith("/hello")) {
                            System.out.println("Hello World!!");
                        }
                    }else{
                        System.out.println("Server :: ");
                        strResponse = bufferedReader2.readLine();
                    }
                    printStream.println(strResponse);
                }
                printStream.close();
                bufferedReader.close();
                bufferedReader2.close();
                server.close();
                socket.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}