# Unit 05: URL Connections

## 5.1: Opening URL Connections

A program that uses the URLConnection class directly follows this basic sequence of steps:

1. Construct a URL object.

2. Invoke the URL object’s openConnection() method to retrieve a URLConnection object for that URL.

3. Configure the URLConnection.

4. Read the header fields.

5. Get an input stream and read data.

6. Get an output stream and write data.

7. Close the connection.

You don’t always perform all these steps. For instance, if the default setup for a particular kind of URL is acceptable, you can skip step 3. If you only want the data from the server and don’t care about any meta-information, or if the protocol doesn’t provide any meta-information, you can skip step 4. If you only want to receive data from the server but not send data to the server, you’ll skip step 6. Depending on the protocol, steps 5 and 6 may be reversed.

```java
import java.net.*;
import java.io.*;
import java.util.Date;

public class URLConnectionDemo{
    public static void main(String[] args) throws Exception{
        try{
        URL url = new URL("https://www.javatpoint.com/java-networking");
        URLConnection connection = url.openConnection();
        System.out.println("Content-Type: " + connection.getContentType());
        }catch(MalformedURLException e){
            System.err.println(e);
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
```

## 5.2: Reading Data from Server

There’s a lot of information there. In general, an HTTP header may include the content type of the requested document, the length of the document in bytes, the character set in which the content is encoded, the date and time, the date the content expires, and the date the content was last modified. However, the information depends on the server; some servers send all this information for each request, others send some information, and a few don’t send anything. The methods of this section allow you to query a URL Connection to find out what metadata the server has provided.

Aside from HTTP, very few protocols use MIME headers (and technically speaking, even the HTTP header isn’t actually a MIME header; it just looks a lot like one). When writing your own subclass of URLConnection, it is often necessary to override these methods so that they return sensible values. The most important piece of information you may be lacking is the content type. URLConnection provides some utility methods that guess the data’s content type based on its filename or the first few bytes of the data itself.

## 5.3: Reading Header: Retrieving specific Header Fields and Retrieving Arbitrary Header Fields.

The first six methods request specific, particularly common fields from the header. These are:

1. Content-type

2. Content-length

3. Content-encoding

4. Date

5. Last-modified

6. Expires

- public String getContentType()

    The getContentType() method returns the MIME content of the data. It throws no exceptions and returns null if the content type isn’t available. text/html will be the most common content type you’ll encounter when connecting to web servers. Other commonly used types include text/plain, image/gif, application/xml, and image/jpeg.

```
Content-type: text/html; charset=UTF-8
Content-Type: application/xml; charset=iso-2022-jp
```
- public int getContentLength()

    The getContentLength() method tells you how many bytes there are in the content. If there is no Content-length header, getContentLength() returns –1. The method throws no exceptions. Many servers send Content-length headers only when they’re transferring a binary file, not when transferring a text file.

- public String getContentEncoding()
    
    The getContentEncoding() method returns a String that tells you how the content is encoded. If the content is sent unencoded (as is commonly the case with HTTP servers), this method returns null. It throws no exceptions. The most commonly used content encoding on the Web is probably x-gzip, which can be straightforwardly decoded using a java.util.zip.GZipInputStream. The content encoding is not the same as the character encoding.

- public long getDate()
    
    The getDate() method returns a long that tells you when the document was sent, in milliseconds since midnight, Greenwich Mean Time (GMT), January 1, 1970. You can convert it to a java.util.Date. For example:

```
Date documentSent = new Date(uc.getDate());
```

- public long getExpiration()

    Some documents have server-based expiration dates that indicate when the document should be deleted from the cache and reloaded from the server. getExpiration() is very similar to getDate(), differing only in how the return value is interpreted. It returns a long indicating the number of milliseconds after 12:00 A.M., GMT, January 1, 2021, at which the document expires. If the HTTP header does not include an Expiration field, getExpiration() returns 0, which means that the document does not expire and can remain in the cache indefinitely.

- public long getLastModified()
    
    getLastModified method returns the date on which the document was last modified.Again, the date is given in miliseconds since midnight, GMT, January 1, 2021. If header does not include Lastmodified header, this method returns 0.


## 5.4: Cache: Web Cache for Java

## 5.5: Contiguring the Connection: protected URL url, protected boolean connected, protected boolean allowUserInteraction, protected boolean doInput, protected boolean doOutput, protected boolean ifModificationSince, protected boolean useCaches and Timeouts

## 5.6: Configuring the Client Request HTTP Header

## 5.7: Security Considerations for URLConnections

## 5.8: Guessing MIME Media Types

## 5.9: HttpURLConnection: The Request Methods, Disconnecting from the Server, Handling Server Responses, Proxies and Streaming Mode
