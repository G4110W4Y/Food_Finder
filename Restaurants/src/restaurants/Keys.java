package restaurants;


import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Class used to abstract the use of an api key and add the appropriate delay.
 * 
 * @author Austin Pohlmann
 * @author Chad Galloway
 */
public class Keys {

    private long time = 0;
    private String key = null;

    /**
     * Create an object for returning an api key.
     * 
     * @param filename the path to a file containing an api key to be used
     */
    public Keys(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try (Scanner read = new Scanner(file)) {
                key = read.nextLine();
            } catch (Exception e) {
                System.out.println("Exception " + e + "caught!!!");
            }
        }
    }

    /**
     * Get the api key to be used for and sleep until it is safe to make another api request.
     * If calls for an api key are made within a certain time frame(for certain operations), it will likely fail.
     * The time it sleeps for depends on how much time has elapsed since last called
     * @return a string containing an api key
     */
    public String getDelay() {
        long current = System.currentTimeMillis();
        long delay;
        if ((delay = current - time) < 2000) {
            try {
                TimeUnit.MILLISECONDS.sleep(2000 - delay);
            } catch (Exception e) {
                System.out.println("Sleeping interrupted, API request might fail!!!");
            }
        }
        time = System.currentTimeMillis();
        return key;
    }
    
    /**
     * Get the api key.
     * @return a string containing an api key
     */
    public String get(){
        return key;
    }
    /**
     * Set the current system time.
     * This should be called after the request finishes
     */
    public void setTime(){
        time = System.currentTimeMillis();
    }
}
