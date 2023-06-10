import java.net.*;
import java.io.*;

public class URIData {
    public static void main(String[] args) throws Exception {
        // Create a URL object for the URI you want to retrieve
        URL url = new URL("https://animechan.vercel.app/api/random");
        
        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set the request method
        connection.setRequestMethod("GET");
        
        // Read the response from the connection
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        
        // Print the response
        System.out.println(response.toString());
        
        // Disconnect the connection
        connection.disconnect();
    }
}
