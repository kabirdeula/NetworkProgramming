import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ProxySelectorDemo {
    public static void main(String[] args) {
        // Set the default proxy for all connections
        ProxySelector.setDefault(new CustomProxySelector());

        try {
            // Create a URL object
            URL url = new URL("https://www.example.com");

            // Open a connection using the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Read the response
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class CustomProxySelector extends ProxySelector {
        @Override
        public List<Proxy> select(URI uri) {
            // Create a list to hold the available proxies
            List<Proxy> proxies = new ArrayList<>();

            proxies.add(Proxy.NO_PROXY);

            return proxies;
        }

        @Override
        public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
            // Handle connection failures if needed
            System.out.println("Failed to connect to the proxy.");
        }
    }
}
