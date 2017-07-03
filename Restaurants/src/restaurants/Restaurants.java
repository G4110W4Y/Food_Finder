// Chad Galloway
//

package restaurants;
import java.awt.Event;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Restaurants {

   
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        Scanner input = new Scanner(System.in);
        
        URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants&location=30.2241,92.0198&radius=10000&key=cdg6913");
        /*From what i understand this url should return information in json format in regards to restaurants in lafayette within 10000 meters
        or a little over 6 miles.*/
        try (InputStream is = url.openStream();
            JsonParser parser = Json.createParser(is)){
            while (parser.hasNext()){
                Event e = parser.next();
            }
        }
    }

}
