package screen;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HttpClass {

    public static void main(String[] args) {

        try {
            URL url = new URL(" ");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.getDate();
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpClass.class.getName()).log(Level.SEVERE, null, ex);
        } 

}
}
 
