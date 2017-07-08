package restaurants;

public class PlaceSearch {
    String next_page_token;
    PlaceData[] results;
    String status;
    public class PlaceData{
        String formatted_address;
        String icon;
        String id;
        String name;
        double rating;
        String[] types;
        Double price_level;
        Geo geometry;
        public class Geo{
            Coords location;
            public class Coords{
                Double lat;
                Double lng;
            }
        }
    }
}
