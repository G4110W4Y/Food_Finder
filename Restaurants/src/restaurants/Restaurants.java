// Chad Galloway
//

package restaurants;
import java.awt.Event;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import com.google.gson.*;
import java.io.InputStreamReader;



public class Restaurants {

   
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        Scanner input = new Scanner(System.in);
        Gson parser = new Gson();
        InputStreamReader reader = null;
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants&location=30.2241,-92.0198&radius=10000&key=AIzaSyCmylGp6EXQMzEmvP8euBhv3WnrVZrsDOc");
            reader = new InputStreamReader(url.openStream());
        } catch (Exception e) {
        }
        PlaceSearch data = parser.fromJson(reader, PlaceSearch.class);
        System.out.println(data.results[0].name+"");
    }

}
