import java.net.*;

public class SplittingURI {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java URLInfo <url>");
            System.exit(1);
        }
        try {
            URI url = new URI("foo://example.com:8042/over/there?name=ferret#nose");
            
            // URL url = new URL("https://www.tutorialspoint.com/javaexamples/net_singleuser.htm");
            System.out.println("Protocol: " + url.getScheme());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("File: " + url.getFragment());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("Query: " + url.getQuery());
            // System.out.println("Default Port: " + url.getDefaultPort());
        } catch (URISyntaxException e) {
            System.err.println("Invalid URL: " + args[0]);
        }
    }   
} 



