# Unit 03: URLs and URIs

| URL | URI | URN |
| --- | --- | --- |
| Uniform Resource Locator | Uniform Resource Identifier | Uniform Resource Name |
| Identify and Locate a resource | Identify a resource | Identify a resource |
| All URLs are URIs. Not all URIs are URLs. URLs are not URN. | All URLs and URNs are URI.  | All URNs are URIs. Not all URIs are URNs. URNs are not URls. |
| The scheme specifies the protocol to access the resource. | Can use any scheme (http, https, file, etc.) | Use the URN scheme |
| You can create your own URL, provided you control its domain name | You can create your own URI, although using a registered domain name is recommended. | URNs are usually assigned by a specific standard organization |
| Example http://www.example.com/java-tutorial | Example: XML namespace identifier https://the-great-chef.com/language/recipe| Example - urn: ISBN:123456789 |

## Absolute URL vs Relative URL

| Absolute URL | Relative URL |
| --- | --- |
| It is the complete address of a document on the internet. | It is the partial address of a document on the internet. |
| Absolute URL contains all the information that are required to find the files on the internet.  | Relative URL contains only file name or file name with folder name. |
| If any of the parts is missing then the browser would not able to link to the specific file. | We can use this type of URL when the file is on the same server related to the original document. |
| Example: ```<a href="https://www.example.com/xyz.html">``` | Example: ```<a href="/xyz.html">``` |

## Methods of URL Class

| methods | meanings |
| --- | --- |
|1. public String getProtocol()   | It return the protocol of URL |
|2. public String getHost()       | It return the host name of URL |
|3. public String getPort()       | It return the port of URL |
|4. public String getFile()       | It return the file name of URL |
|5. public String getAuthority()  | It return the Authority of the URL |
|6. public String getQuery()      | It return the Query of URL |
|7. public String getDefaultPort()| It return the default port of URL |
