package restaurants;


import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Class used to abstract the use of api key(s) and add the appropriate delay.
 * 
 * @author Austin Pohlmann
 * @author Chad Galloway
 */
public class Keys {

    private int num = 0;
    private long time = 0;
    ArrayList<String> keys = new ArrayList();

    /**
     * Create an object for returning api keys.
     * 
     * @param filename the path to a file containing any api keys to be used
     */
    public Keys(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try (Scanner read = new Scanner(file)) {
                while (read.hasNext()) {
                    keys.add(read.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Exception " + e + "caught!!!");
            }
        }
    }

    /**
     * Get the next api key to be used and sleep until it is safe to make another api request.
     * If calls for an api key are made within a certain time frame, it will likely fail.
     * The time it sleeps for depends on how many keys are being used
     * @return a string containing an api key
     */
    public String get() {
        long current = System.currentTimeMillis();
        int delay;
        if (current - time < (delay = 2000 / keys.size())) {
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (Exception e) {
                System.out.println("Sleeping interrupted, API request might fail!!!");
            }
        }
        time = System.currentTimeMillis();
        return keys.get((num = (num+1)%keys.size()));
    }
}
