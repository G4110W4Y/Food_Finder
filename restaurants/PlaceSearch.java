package restaurants;


public class PlaceSearch {
    String next_page_token;
    PlaceData[] results;
    
    public class PlaceData {
        String formatted_address;
        String icon;
        String id;
        String name;
        double rating;
        String[] types; //it seems that most restaurants dont have their type specified
        Double price_level;
    }
}
