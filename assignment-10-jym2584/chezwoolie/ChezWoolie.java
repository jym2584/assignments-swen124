package chezwoolie;

import java.util.*;

import javax.sql.rowset.spi.SyncResolver;

/**
 * Restaurant class
 */

public class ChezWoolie {
    private int numDiners;
    private LinkedList<Food> belt;

    public ChezWoolie(LinkedList<Food> belt) {
        this.numDiners = 0;
        this.belt = belt;
    }

    /**
     * Increases the number of diners in the restaurant 
     */
    public void enter() {
        synchronized(belt) {
            belt.notify(); // notifies the chef that is waiting to serve food, if applicable
        }
        numDiners++;
    }

    /**
     * Decreases the number of diners in the restaurant 
     */
    public synchronized void exit() {
        numDiners--;
    }

    /**
     * Adds the food to the queue
     * @param food
     */
    public void serve(Food food) {
        synchronized(belt) {
            belt.notifyAll(); // notifies all the Threads that are waiting for food
            belt.add(food);
        }      
    }

    /**
     * Removes the food at the front of the queue
     */
    public void retrieve() {
        if(!belt.isEmpty()) {
            synchronized(belt) {
            belt.remove();
            }
        }
    }
    
    /**
     * If there are currently no diners in the restaurant
     * @return
     */
    public boolean isEmpty() {
        if (numDiners == 0) {
            return true;
        }

        return false;
    }

    public int getNumDiners() {
        return numDiners;
    }

    public LinkedList<Food> getBelt() {
        return belt;
    }

}
