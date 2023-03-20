import java.net.URLEncoder;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class URIDemo {
    public static void main(String[] args) {
        String originalURI = "http://www.example.com/path with spaces?query=param&another_query=another_param";
        String encodedURI = null;
        String decodedURI = null;
        String charset = "UTF-8"; // the character encoding to be used for encoding/decoding

        // Encoding the URI
        try {
            encodedURI = URLEncoder.encode(originalURI, charset);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error encoding URI: " + e.getMessage());
        }
        System.out.println("Encoded URI: " + encodedURI);

        // Decoding the URI
        try {
            decodedURI = URLDecoder.decode(encodedURI, charset);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error decoding URI: " + e.getMessage());
        }
        System.out.println("Decoded URI: " + decodedURI);
    }
}
