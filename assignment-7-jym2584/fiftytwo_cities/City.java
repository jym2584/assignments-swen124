package fiftytwo_cities;
import java.lang.Math;
/**
 * Class representing a city
 */
public class City {
    private final String name;
    private final String state;
    private final Double latitude;
    private final Double longitude;

    /**
     * Representing a city 
     * @param name City name
     * @param state city state
     * @param latitude city location latitude
     * @param longitude city location longitude
     */
    public City(String name, String state, Double latitude, Double longitude) {
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Gets the euclidean distance from and to a city
     * @param to ending city
     * @return returns the distance from and to city
     */
    public double distanceFrom (City to) {
        return Math.sqrt(
                Math.abs(
                    Math.pow(latitude - to.getLatitude(),2) + 
                    Math.pow(longitude - to.getLongitude(),2)
                )
        );
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof City)) {
            return false;
        }
    
        City other = (City)(o);
        return ( latitude.equals(other.getLatitude()) && longitude.equals(other.getLongitude()) );
    }
    
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return name + ", " + state;
    }
    // Accessors
    public String getName() { return name; }
    public String getState() { return state; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getCoordinates() { 
        return toString() + " coordinates: " + latitude + "° N, " + longitude + "° W"; 
    }


    public static void main(String[] args) {
        City east_hills = new City("East Hills", "NY", 40.8, -73.63);
        City indian_wells = new City("Indian Wells", "PA", 33.7, -116.34);
        System.out.println(east_hills.distanceFrom(indian_wells));

        City east_hills2 = new City("East Hills", "NY", 40.8, -73.63);
        System.out.println(east_hills.equals(east_hills2));

    }
}
