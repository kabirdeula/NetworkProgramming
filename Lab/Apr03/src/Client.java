import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
    public static void main(String[] args) {
        try {
            try (
                // Reading Host IP address and port given by the user.
            Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter host address: ");
                String host = scanner.nextLine();
                System.out.println("Enter port address: ");
                int port = Integer.parseInt(scanner.nextLine());

                // Connecting to socket using host and port provided by user.
                Socket socket = new Socket(host, port);
                System.out.println("Connection to server accepted.");

                // I/o stream to read and write data
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));

                String strRequest, strResponse;
                System.out.println("/'quit/' to exit");
                while (!(strRequest = bufferedReader2.readLine()).equals("quit")) {
                    // dataOutputStream to write to the server.
                    dataOutputStream.writeBytes(strRequest + "\n");
                    strResponse = bufferedReader.readLine();
                    System.out.println("Server: " + strResponse);
                    System.out.println("Client: ");
                }
                dataOutputStream.close();
                bufferedReader.close();
                bufferedReader2.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}