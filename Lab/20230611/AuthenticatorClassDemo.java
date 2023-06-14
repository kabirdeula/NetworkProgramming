import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

public class AuthenticatorClassDemo{
    public static void main(String[] args) {
        try {
            ClassAuthenticator obj1 = new ClassAuthenticator();
            Authenticator.setDefault(new ClassAuthenticator());

            URL url = new URL("http://192.168.1.72:8000/login");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            System.out.println("Host using url.getHost:: "+url.getHost());
            obj1.getPasswordAuthentication();
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e){
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

    public static class ClassAuthenticator extends Authenticator{
        protected PasswordAuthentication getPasswordAuthentication(){
            this.show();
            String username = "kabirdeula";
            String password = "kabirdeula";
            return new PasswordAuthentication(username, password.toCharArray());
        }

        void show(){
            int hostname = getRequestingPort();
            System.out.println("Port Requesting: " + hostname);
        }
    }
}
