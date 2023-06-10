import java.net.*;
import java.util.Scanner;

public class GetIPAddress{
    public static void main(String[] args){
        try (
        Scanner input = new Scanner(System.in)) {
            System.out.print("Enter Domain Name: ");
            String ipAddress = input.next();
            try{
                InetAddress address = InetAddress.getByName(ipAddress);
                System.out.print(ipAddress + ": " + address);
            }catch(UnknownHostException e){
                System.out.println("Could not find IP address of " + ipAddress);
            }
        }
    }
}