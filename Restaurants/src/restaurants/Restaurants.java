// Chad Galloway
//
package restaurants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import com.google.gson.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Restaurants {

    public static void main(String[] args) throws MalformedURLException, IOException {

        Scanner input = new Scanner(System.in);
        Gson parser = new Gson();
        // replace this with the filename of the file containing a key to use
        Keys key = new Keys("keys");
        ArrayList<PlaceSearch.PlaceData> places = new ArrayList();
        BufferedReader reader;
        URL url;
        //use get() to instantly get the key, and use setTime() after the url is read
        url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants&location=30.2241,-92.0198&radius=5000&key=" + key.get());
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        PlaceSearch data = parser.fromJson(reader, PlaceSearch.class);
        key.setTime();
        places.addAll(Arrays.asList(data.results));
        System.out.println(data.status);
        
        while (data.next_page_token != null) {
            // Since we use getDelay() here, it will wait until 2 seconds after the last call to setTime() before returning
            url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?pagetoken=" + data.next_page_token + "&key=" + key.getDelay());
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            data = parser.fromJson(reader, PlaceSearch.class);
            key.setTime();
            places.addAll(Arrays.asList(data.results));
            //Print status to make sure google doesn't say invalid request
            System.out.println(data.status);
        }
        
        System.out.println("Number of places: " + places.size());
        Collections.sort(places, new DistanceComparator(30.212159,-92.0470944));
        for(PlaceSearch.PlaceData place: places){
            System.out.println(place.name +"\n"+place.formatted_address+"\n");
        }

    }

}
