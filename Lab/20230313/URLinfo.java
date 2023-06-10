import java.net.*;

public class URLinfo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java URLInfo <url>");
            System.exit(1);
        }
        try {
            URL url = new URL("https://www.tutorialspoint.com/javaexamples/net_singleuser.htm");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("File: " + url.getFile());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Default Port: " + url.getDefaultPort());
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + args[0]);
        }
    }
}



