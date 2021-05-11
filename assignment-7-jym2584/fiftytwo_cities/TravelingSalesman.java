package fiftytwo_cities;
import java.io.*;
import java.util.*;
import graphs.*;
/**
 * Dijkstra's Algorithm uses the most optimal route in getting to the location, which defeats the salesman's goals of 
 * visiting nearby cities that are the most convenient to him from the origin to the destination.
 */

public class TravelingSalesman {

    /**
     * Creating a list of cities from a csv file
     * @param filename filename
     * @return returns a list of cities
     */
    public static List<City> buildCitiesFromCSV(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine(); // Reading from header
            line = br.readLine(); // Reading from the first line

            List<City> cities = new LinkedList<>();

            while(line != null) {
                String[] tokens = line.split(",");

                String name = tokens[0];
                String city = tokens[1];
                double latitude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);

                cities.add(new City(name, city, latitude, longitude));

                line = br.readLine();
            }


        return cities;

        } catch (IOException ioe) {
            return null;
        }
    }

    /**
     * Building the graph of the cities
     * @param cities list of cities
     * @return returns a weighted graph of cities
     */
    public static WGraph<City> buildWGraphFromCities(List<City> cities) {
        WGraph<City> graph = new WAdjacencyGraph<>();

        // Adds each city to the graph
        for(City city: cities) {
            graph.add(city);
        }

        // Connects each of the city with its distance
        for(City city_from: cities) {
            for (City city_to: cities) {
                if(!city_to.equals(city_from)) { // Prevents the same cities from getting connected if their long/lat is the same
                    graph.connect(city_to, city_from, city_to.distanceFrom(city_from));
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        List<City> cities = buildCitiesFromCSV("fiftytwo_cities/52cities.csv");
        WGraph<City> graph = buildWGraphFromCities(cities);
        Scanner scanner = new Scanner(System.in);
        
        // While both inputs are not empty
        while(true) {
            // Grabbing input
            System.out.print("Enter origin city: ");
            String input = scanner.nextLine();
            System.out.print("Enter destination city: ");
            String input2 = scanner.nextLine();
            
            // Checking for empty inputs before running the rest of the program
            if(input.equals("") && input2.equals("")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                // Grabbing cities
                City city_1 = null;
                City city_2 = null;

                for(City city: cities) {
                    if(city.toString().equals(input)) {
                        city_1 = city;
                    }
                    if(city.toString().equals(input2)) {
                        city_2 = city;
                    }
                }

                // If either cities are invalid
                String message = "Invalid Cities: ";
                boolean error = false;

                if((city_1 == null)) {
                    error = true;
                    message += "\n  - Origin: " + input;
                }
                if (city_2 == null) {
                    error = true;
                    message += "\n  - Destination: " + input2;
                }
                if(error) {
                    throw new IllegalArgumentException(message + "\nTry again.");
                }

                // If the cities are valid
                System.out.println(graph.nearestNeighbors(city_1, city_2));
                break;

                
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        
        }

        scanner.close();

    }
}
