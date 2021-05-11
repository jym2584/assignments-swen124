package chezwoolie;
import java.util.*;

import org.w3c.dom.Text;
/**
 * Main method to run the ChezWoolie program
 */
public class Main {
    /**
     * Woolieseconds
     */
    protected static final int WOOLIECONDS = 100;

    /**
     * Adding foods here
     */
    protected static final LinkedList<Food> FOODS = new LinkedList<>(); static {
        List<String> foodNames = Arrays.asList(
            "Carrot Cake", "Fish", "Wolf Meat", "Pie", 
            "Bacon", "Ham", "Cheese", "Pancake Dressing",
            "Lemon", "Grapes");

        for(String food: foodNames) {
            FOODS.add(new Food(food, 1 + new Random().nextInt(10)));
        }

    }

    /**
     * Adding diners here
     */
    protected static final LinkedList<String> DINER_NAMES = new LinkedList<>(); static {
        DINER_NAMES.add("Bob");
        DINER_NAMES.add("Joe");
        DINER_NAMES.add("Bruce");
        DINER_NAMES.add("Jane");
        DINER_NAMES.add("Harry");
        DINER_NAMES.add("Wolf");
        DINER_NAMES.add("Spy");
        DINER_NAMES.add("Valerie");
        DINER_NAMES.add("Clear");
        DINER_NAMES.add("Fail");
    }

    /**
     * Main program
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Initializing everything
        System.out.println(TextColor.GREEN + "Chez Woolie is opening for the day!");
        Thread.sleep(1);

        LinkedList<Food> conveyorBelt = new LinkedList<>();
        ChezWoolie restaurant = new ChezWoolie(conveyorBelt);

        int numChefs = 2;
        Chef[] chefs = new Chef[numChefs];
        Thread[] threadChefs = new Thread[numChefs];

        Thread[] threadDiners = new Thread[DINER_NAMES.size()];

        for(int i = 0; i < chefs.length; i++) {
            chefs[i] = new Chef("CHEF #" + (i + 1), restaurant);
        }
        
        // Run the chef threads
        for(int i = 0; i < threadChefs.length; i++) {
            threadChefs[i] = new Thread(chefs[i]);
            threadChefs[i].start();
        }
        
        // Run the diners
        for(int i = 0; i < threadDiners.length; i++) {
            Diner diner = new Diner(DINER_NAMES.get(i) + " (Diner #" + (i + 1) + ")", restaurant);
            threadDiners[i] = new Thread(diner);
            Thread.sleep(WOOLIECONDS * (1 + new Random().nextInt(6)));
            threadDiners[i].start();
        }

        // Constantly checking if all the chefs are done for the day before closing
        int count = 0;
        while (count != 3) {
            if(count == 2) {
                System.out.println(TextColor.GREEN + "The restaurant is closed for the day!");
                System.out.print(TextColor.DEFAULT);
                break;
            }
            if(chefs[count].isFinished()) {
                count++;
            } else {
                count = 0;
            }
        }
    }
}
