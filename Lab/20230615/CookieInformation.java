import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.util.List;

public class CookieInformation {
    public static void main(String[] args) {
        try {
            // Create a CookieManager
            CookieManager cookieManager = new CookieManager();
            // Set the CookieManager as the default CookieHandler
            java.net.CookieHandler.setDefault(cookieManager);

            // Perform an HTTP request to get cookies
            // Replace this URL with the URL you want to fetch cookies from
            java.net.URL url = new java.net.URL("https://www.facebook.com");
            url.openConnection().getContent();

            // Get the CookieStore from the CookieManager
            CookieStore cookieStore = cookieManager.getCookieStore();

            // Get the list of cookies
            List<HttpCookie> cookies = cookieStore.getCookies();

            // Display cookie information
            System.out.println("Cookies stored in your system:");
            for (HttpCookie cookie : cookies) {
                System.out.println("Name: " + cookie.getName());
                System.out.println("Value: " + cookie.getValue());
                System.out.println("Domain: " + cookie.getDomain());
                System.out.println("Path: " + cookie.getPath());
                System.out.println("Secure: " + cookie.getSecure());
                System.out.println("HTTP Only: " + cookie.isHttpOnly());
                System.out.println("Max Age: " + cookie.getMaxAge());
                System.out.println("---------------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
