import java.io.*;
import java.net.*;

public class Client {
    private Socket socket = null;
    private BufferedReader inputStream = null;
    private DataOutputStream outputStream = null;
    
    public Client(String address, int port){
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            System.out.println(e);
            return;
        }catch(IOException e){
            System.out.println(e);
            return;
        }
        
        String line = " ";
        
        while(!line.equals("Over")){
            try{

                line = inputStream.readLine();
                outputStream.writeUTF(line);
            }catch(IOException e){
                System.out.println(e);
            }
        }
        
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 5000);
    }

}
