import java.net.*;
import java.util.Scanner;

public class getname{
    public static void main(String[] args){
        try (// String[] ipAddresses = {
                        // "www.facebook.com",
                        // "www.google.com",
                        // "www.javapoint.com",
                        // "www.youtube.com"
                        // };
                // System.out.println("IP Address using getByName:");
                // for(String ipAddress: ipAddresses){
                //     try{
                //         InetAddress address = InetAddress.getByName(ipAddress);
                //         System.out.println(ipAddress + ": " + address.getHostAddress());
                //     } catch (UnknownHostException e) {
                //         System.out.println("Could not find IP address of " + ipAddress);
                //     }
                // }
        Scanner input = new Scanner(System.in)) {
            System.out.println("Enter Domain Name: ");
            String ipAddress = input.next();
            try{
                InetAddress address = InetAddress.getByName(ipAddress);
                System.out.println(ipAddress + ": " + address.getHostAddress());
            }catch(UnknownHostException e){
                System.out.println("Could not find IP address of " + ipAddress);
            }
        }
    }
}