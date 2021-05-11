package activities;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Thread( () -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}

                System.out.println("Hello world!");
            }
            
            ));
            list.get(i).start(); // start the thread
            //list.get(i).join(); // wait until that thread finishes
            /* Problem with .join() inside of for loop:
                - Each thread will wait 1 second each (for a total of 5)
            */
            
        }

        for(int i = 0; i < 5; i++) {
            list.get(i).join(); // waited 1 second concurrently
        }
        System.out.println("Goodbye!");

    }
}