package restaurants;

import java.util.Comparator;

public class DistanceComparator implements Comparator<PlaceSearch.PlaceData>{
    private Double lng;
    private Double lat;

    public DistanceComparator(Double lat, Double lng) {
        this.lng = lng;
        this.lat = lat;
    }

    @Override
    public int compare(PlaceSearch.PlaceData o1, PlaceSearch.PlaceData o2) {
        Double p1, p2;
        p1 = Math.sqrt(Math.pow(o1.geometry.location.lat - lat, 2) + Math.pow(o1.geometry.location.lng - lng, 2));
        p2 = Math.sqrt(Math.pow(o2.geometry.location.lat - lat, 2) + Math.pow(o2.geometry.location.lng - lng, 2));
        if(p1 < p2){
            return -1;
        } else if(p2 > p1) {
            return  1;
        } else {
            return 0;
        }
    }
    
    
}
