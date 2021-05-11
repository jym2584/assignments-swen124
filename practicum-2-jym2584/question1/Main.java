package question1;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * The main class below creates a list of planets.
 * Planets have a diameter and an orbit (both in KM)
 * 
 * For the first Collections.sort you will need to make
 * planet comparable by diamater.
 * 
 * For the second Collections.sort you will need to make
 * a PlanetComparator which compares orbits.
 * 
 * You may want to comment out the second sort while you work on the first one.
 * 
 */
public class Main {
    public static void main(String[] args) {
        List<Planet> solarSystem = new LinkedList<>();
        solarSystem.add(new Planet("Earth", 12756l, 149600000l));
        solarSystem.add(new Planet("Jupiter", 142984l, 778369000l));
        solarSystem.add(new Planet("Mars", 6794l, 227936640l));
        solarSystem.add(new Planet("Mercury", 4878l, 57900000l));
        solarSystem.add(new Planet("Neptune", 49532l, 4496976000l));
        solarSystem.add(new Planet("Saturn", 120536l, 1427034000l));
        solarSystem.add(new Planet("Uranus", 51118l, 2870658186l));
        solarSystem.add(new Planet("Venus", 12704l, 108160000l));

        for (Planet planet : solarSystem) {
            System.out.println(planet);
        }
        System.out.println();
        // Uncomment the next line to test Comparable
        // Collections.sort(solarSystem); 
        for (Planet planet : solarSystem) {
            System.out.println(planet);
        }
        System.out.println();
        // Uncomment the next line to test Comparator
         Collections.sort(solarSystem, new PlanetComparator()); 
        for (Planet planet : solarSystem) {
            System.out.println(planet);
        }

    }
}
