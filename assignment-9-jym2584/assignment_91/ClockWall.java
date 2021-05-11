package assignment_91;
import java.util.*;
import java.util.Map.Entry;
import java.time.*;

public class ClockWall {
    
    private interface Clock {
        String getTime();
    }

    /**
     * Converting 24 hour to 12
     * @param hour grabbing hour
     * @return returns a list of hour and the meridiem
     */
    private static ArrayDeque<String> convertTo12Hours(int hour) {
        ArrayDeque<String> hourAndMeridiem = new ArrayDeque<>(); // For o(1) time complexity
        String meridiem = hour > 11 ? "PM" : "AM";
        int convertHour = (hour %= 12) == 0 ? 12 : hour;

        hourAndMeridiem.add(Integer.toString(convertHour));
        hourAndMeridiem.add(meridiem);
        return hourAndMeridiem;
    }

    /**Gets the UTC time via its offset
     * @param offset offset
     * @return a list of time in hour and minute
     */
    public static ArrayDeque<Integer> getUtcOffset(int offset) {
        ArrayDeque<Integer> time = new ArrayDeque<>();
        LocalTime now = LocalTime.now(ZoneOffset.UTC.ofHours(offset));
        int hour = now.getHour();
        int minute = now.getMinute();
        time.add(hour);
        time.add(minute);
        return time;
    }
    
    /**
     * Static map of city and Clock with its respective time
     */
    /*
    private static final Map <String, Clock> citiesTime = new HashMap<> (); 
    static {
        citiesTime.put("Rochester", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(-4); // Rochester UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        citiesTime.put("Dallas", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(-5); // Dallas UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        citiesTime.put("Salt Lake City", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(-6); // Salt Lake City UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        citiesTime.put("Tokyo", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(9); // Tokyo UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

    }
    */

    public static void main(String[] args) {
        /**
         * Put these onto main instead per-instructions to the assignment
         */
        Map <String, Clock> citiesTime = new HashMap<> ();
        citiesTime.put("Rochester", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(-4); // Rochester UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        citiesTime.put("Dallas", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(-5); // Dallas UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        citiesTime.put("Salt Lake City", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(-6); // Salt Lake City UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        citiesTime.put("Tokyo", () -> {
            ArrayDeque<Integer> getTime = getUtcOffset(9); // Tokyo UTC
            ArrayDeque<String> getHourAndMeridiem = convertTo12Hours(getTime.getFirst());
            
            return getHourAndMeridiem.getFirst() + ":" + String.format("%02d", getTime.getLast()) + " " + getHourAndMeridiem.getLast();
        });

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(Entry<String, Clock> cities : citiesTime.entrySet()) {
            System.out.println(cities.getKey() + " - " + cities.getValue().getTime());
        }
    }
}

