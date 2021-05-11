package chezwoolie;
import java.util.*;
/**
 * Chef runnable class
 */
public class Chef implements Runnable {

    private String name;
    private ChezWoolie restaurant;
    private boolean startedShift;
    private boolean finished;
    /**
     * Producer class
     * @param name
     */
    public Chef(String name, ChezWoolie restaurant) {
        this.name = name;
        this.restaurant = restaurant;
        this.finished = false;
    }

    /**
     * Chef cooking
     * Waits before cooking food if there are no customers
     * Otherwise cook food and put it on the conveyorbelt
     * Leaves after all the customers left
     */
    @Override
    public void run() {
        while(true) {
            try {
                    if (startedShift == true && restaurant.isEmpty()) {
                        finished = true;
                        break;
                    } else if (restaurant.isEmpty()) {
                        System.out.println(TextColor.DEFAULT + name + " is early! Waiting for customers to enter...");
                        synchronized(restaurant.getBelt()) {
                            restaurant.getBelt().wait();
                        }
                    } else {
                            startedShift = true;
                            Food food = Main.FOODS.get(new Random().nextInt(Main.FOODS.size()));
                            System.out.println(TextColor.BLUE + "   > " + name + " begins to prepare " + food);

                            Thread.sleep(Main.WOOLIECONDS * 4);
                            restaurant.serve(food);
                            System.out.println(TextColor.BLUE + "   > " + name + " finishes " + food + " and places it on the conveyer belt");
                    }
            } catch (InterruptedException e) {}
        }

        System.out.println(TextColor.DEFAULT + name + " is done cooking for the night.");
    }

    @Override
    public String toString() {
        return "Chef{" + name + "}";
    }

    /**
     * If the chef is done for the day
     */
    public boolean isFinished() {
        return finished;
    }
}
