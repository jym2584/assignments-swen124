package activities;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses threads to concurrently add integer values to a list, and then prints
 * the total number of values that were successfully added.
 * 
 * @author GCCIS Faculty.
 */
public class ListAdder implements Runnable {
    /**
     * The number of integer values to add to the list.
     */
    private static final int NUMBER_TO_ADD = 100000;
    private static final Object lock = new Object();
    /**
     * The list to which the vinteger alues should be added.
     */
    private List<Integer> list;

    /**
     * Creates a new list adder thread to add integer values to a list.
     * 
     * @param list The list to which the integer values will be added.
     */
    public ListAdder(List<Integer> list) {
        this.list = list;
    }

    /**
     * Uses a loop to add integer values to the list.
     */
    @Override
    public void run() {
        for (int i = 0; i < NUMBER_TO_ADD; i++) {
            synchronized(list) { // or lock
                list.add(i);
            }
        }
    }

    /**
     * Creates 10 list adder threads and starts them. Waits for all of the threads
     * to complete, and then prints the total number of values that were added to
     * the list (which should be 10,000).
     * 
     * @param args The command line arguments. Ignored.
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 10;

        List<Integer> list = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            ListAdder adder = new ListAdder(list);
            Thread thread = new Thread(adder);
            thread.start();
            threads.add(thread);
            //thread.join();
        }

        // use join() to wait for all of the other threads to finish

        /*
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // this will never happen, so squash it
            }
        }
        */
        
        Thread.sleep(10);
        // print the number of integers successfully added
        System.out.println("size (should be " 
            + (numberOfThreads * NUMBER_TO_ADD) + "): " 
            + list.size());
    }
}