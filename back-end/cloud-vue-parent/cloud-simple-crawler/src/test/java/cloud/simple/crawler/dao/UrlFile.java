package cloud.simple.crawler.dao;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlFile {
    public static void main(String[] args) throws IOException {
        try{
            URL url = new URL("http://server.goteaming.com.cn//Content/Files/Answer/822f6419-bde0-4960-aadb-d6c96b8b99b3.jpg");
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            URL url1 = new URL("http://server.goteaming.com.cn//Content/Files/Answer/1822f6419-bde0-4960-aadb-d6c96b8b99b3.jpg");
            DataInputStream dataInputStream1 = new DataInputStream(url1.openStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
