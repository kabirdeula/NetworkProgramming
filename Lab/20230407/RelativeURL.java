import java.net.*;

public class RelativeURL {
    public static void main(String[] args) throws MalformedURLException{
        URL baseUrl = new URL("https://www.google.com/search?q=network+programming&sxsrf=APwXEdeg-kumoSHCL0M0S5rnbCwzAhBZzw%3A1680850458115&ei=Gr4vZJLNBvKbseMPleeqwAk&ved=0ahUKEwiSwufzl5f-AhXyTWwGHZWzCpgQ4dUDCA8&uact=5&oq=network+programming&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIECCMQJzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQguEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDoLCAAQigUQhgMQsANKBAhBGAFQ1QJY5gxgmBFoAXAAeACAAbIBiAG6CpIBAzAuOZgBAKABAcgBAsABAQ&sclient=gws-wiz-serp");
        URL relativeUrl = new URL(baseUrl, "path/to/resource");
        System.out.println(relativeUrl.toString());
    }
}
