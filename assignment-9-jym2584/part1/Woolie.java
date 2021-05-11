package part1;

import java.util.*;

public class Woolie implements Runnable {
    private String name;
    private int travelTime;
    private String destination;

    /**
     * Woolie constructor
     * @param name
     * @param travelTime time in seconds to cross the destination
     * @param destination
     */
    public Woolie (String name, int travelTime, String destination) {
        this.name = name;
        this.travelTime = travelTime;
        this.destination = destination;
    }

    /**
     * gets the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * gets the travel time
     * @return 
     */
    public int getTravelTime() {
        return travelTime;
    }

    /**
     * gets the destination
     * @return
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Prints out the woolie in its toString
     */
    @Override
    public String toString() {
        return "Woolie {" + name + ", " + travelTime + ", " + destination + "}";
    }

    /**
     * Runs the thread
     */
    @Override
    public void run() {
        System.out.println(name + " has arrived at the bridge.");
        for(int i = 0; i < travelTime; i++) {
            if(i == 0) {
                System.out.println("   > " + name + " is starting to cross.");
            } else {
                System.out.println("        - " + name + " " + i + " seconds.");
            }

            try {
                Thread.sleep(1000); // Waits for 1 second before iterating to the next
            } catch (InterruptedException ie) {
                // do nothing
            }
        }
        System.out.println("        - " + name + " " + travelTime + " seconds."); // Since i skips travelTime, we print that here instead
                                                                                  // Doing i <= travelTime will make the iteration last for a second longer
                                                                                  // which is what we don't want

        System.out.println("   > " + name + " leaves at " + destination + "\n");
        
    }

    /**
     * Adding our woolies here instead
     * @return returns an arraylist of woolies for our main
     */
    private static final List<Woolie> woolies = new ArrayList<>(); static {
        woolies.add(new Woolie("Wool John", 4, "NYC"));
        woolies.add(new Woolie("Woolie Jane", 3, "Wuhan"));
        woolies.add(new Woolie("Woola Joe", 5, "Pyongyang"));
        woolies.add(new Woolie("Bobba Woolie", 2, "their house"));
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < woolies.size(); i++) {
            Thread thread = new Thread(woolies.get(i));
            thread.start();
            //thread.join(); // Waits for the thread to die before starting the next thread
        }

        int highest = 0;
        for(Woolie woolie: woolies) {
            if (woolie.getTravelTime() > highest) {
                highest = woolie.getTravelTime();
            }
        }

        Thread.sleep( (highest+1) * 1000); // Waits until a second after to print out that all the woolies have crossed the bridge
        System.out.println("All the woolies have crossed the bridge!");
    }

}
