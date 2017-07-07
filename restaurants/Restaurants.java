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
        BufferedReader reader = null;
        URL url;
        int counter = 0;
        try {
            url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants&opennow&location=30.2241,-92.0198&radius=10000&key=AIzaSyCmylGp6EXQMzEmvP8euBhv3WnrVZrsDOc");
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (Exception e) {
        }
        PlaceSearch data = parser.fromJson(reader, PlaceSearch.class);
        //This prints outs all of the restaurants from the api responses (and iterates over all of the pages if there's more than one)
        
        ArrayList<PlaceSearch.PlaceData> arrayList = new ArrayList();
        
        while(data.next_page_token != null){
            for (PlaceSearch.PlaceData result : data.results) {
                //System.out.println(result.name + " "+ result.formatted_address + " " + result.price_level+" "+result.rating);
                arrayList.add(result);
                counter++;
                
            }
            try {
                //if you don't wait 2 seoncds before making another request google cucks you and tells you INVALID_REQUEST
                TimeUnit.SECONDS.sleep(2);
                url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?pagetoken="+data.next_page_token+"&key=AIzaSyCmylGp6EXQMzEmvP8euBhv3WnrVZrsDOc");
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (Exception e) {
            }
            data = parser.fromJson(reader, PlaceSearch.class);
        }
        for(int x = 0; x <= counter; x++){
            System.out.println(arrayList.get(x).name);
        }
        
    }

}
