import java.io.*;
import java.net.*;

public class WhoisQuery {
    private String server;
    private int port;

    public WhoisQuery(String server, int port) {
        this.server = server;
        this.port = port;
    }

    public String query(String domain) throws IOException {
        StringBuilder result = new StringBuilder();

        try (Socket socket = new Socket(server, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            writer.println(domain);

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String server = "whois.verisign-grs.com"; // Replace with the appropriate WHOIS server
        int port = 43; // Default WHOIS port

        WhoisQuery whois = new WhoisQuery(server, port);

        try {
            String domain = "github.com"; // Replace with the domain you want to query
            String response = whois.query(domain);
            System.out.println("WHOIS Response:\n" + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
