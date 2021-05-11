package fiftytwo_cities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CityTest {
    @Test
    public void testToEquals() {
        City east_hills = new City("East Hills", "NY", 40.8, -73.63);
        City nyc = new City("New York City", "NY", 40.8, -73.63);
        City indian_wells = new City("Indian Wells", "PA", 33.7, -116.34);
        
        assertTrue(east_hills.equals(nyc));
        assertFalse(east_hills.equals(indian_wells));
        assertFalse(nyc.equals(indian_wells));
    }
    
    @Test
    public void testDistanceFrom() {
        City east_hills = new City("East Hills", "NY", 40.8, -73.63);
        City indian_wells = new City("Indian Wells", "PA", 33.7, -116.34);

        assertEquals(43.296121073371005, east_hills.distanceFrom(indian_wells));
    }
}
