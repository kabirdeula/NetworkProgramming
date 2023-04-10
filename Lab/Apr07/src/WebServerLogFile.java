import java.io.*;

public class WebServerLogFile{
    public static void main(String[] args) {
        String logFilePath = "/path/to/webserver.log";

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))){
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}