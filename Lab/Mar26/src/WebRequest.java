import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WebRequest {
    public static void main(String[] args) throws IOException{
        try (// String url = "https://animechan.vercel.app/api/random";
                // String url = "https://kabirdeula.info.np";
        Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the URL: ");
            String url = scan.next();

            URL objUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) objUrl.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }
            input.close();

            System.out.println("Response Data: " + response.toString());
        }
    }
}
