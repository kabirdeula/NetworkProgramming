import java.net.*;
// import java.io.*;

public class HTTPHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://kabirdeula.info.np/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            for (int i = 1; ; i++) {
                String headerName = connection.getHeaderFieldKey(i);
                String headerValue = connection.getHeaderField(i);
                if (headerName == null && headerValue == null) {
                    break;
                }
                System.out.println(headerName + ": " + headerValue);
            }
            connection.disconnect();
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println(e);
        }
    }    
}

