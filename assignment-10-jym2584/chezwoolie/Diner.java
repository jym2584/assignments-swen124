package chezwoolie;
import java.util.*;
/**
 * Diner runnable class
 */
public class Diner implements Runnable {

    /**
     * How hungry the diner is
     */
    private int hungerRating;
    private final String name;
    private ChezWoolie restaurant;

    /**
     * Diner class
     * @param name name of the diner
     * @param restaurant restaurant 
     */
    public Diner(String name, ChezWoolie restaurant) {
        this.name = name;
        this.restaurant = restaurant;
        this.hungerRating = 5 + new Random().nextInt(6); // 5-10
    }

    /**
     * Diner entering the restaurant and eating until hungerRating <= 0
     * Waits if there is no food on the conveyor belt
     * otherwise retrieve the first food on the conveyorbelt and eat it
     * Exits the restaurant if their hunger is <= 0
     * 
     */
    @Override
    public void run() {
        restaurant.enter();
        System.out.println(TextColor.DEFAULT + name + " enters the diner.");
        while(true) { // while the Diner isn't full
            if(restaurant.getBelt().size() == 0) {
                try {
                    System.out.println(TextColor.RED + "   (!) " + name + " is currently waiting for food.");
                    synchronized(restaurant.getBelt()) {
                        restaurant.getBelt().wait();
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                Food food = restaurant.getBelt().getFirst();
                System.out.println(TextColor.DEFAULT + "   > " + name + " begins to eat " + food);
                try { Thread.sleep((long)(Main.WOOLIECONDS * food.getServings())); } catch (InterruptedException e) { }
                restaurant.retrieve();
                this.hungerRating -= food.getServings();

                if(hungerRating <= 0) {
                    System.out.println(TextColor.GREEN + "   > " + name + " finishes eating " + food + " and is full!");
                    restaurant.exit();
                    System.out.println(TextColor.DEFAULT + name + " exits the restaurant!");
                    break;

                } else {
                    System.out.println(TextColor.DEFAULT + "   > " + name + " finishes eating " + food + " (hunger now: " + hungerRating + ")");
                }
            }
        }
    }


    @Override
    public String toString() {
    return "Diner{" + name + ", " + hungerRating + "}";
    }
}
