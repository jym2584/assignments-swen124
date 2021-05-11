package concurrency;

import java.util.Scanner;

public class AnonymousCounters {
    public static void counter(String name) {
        for(int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);
        }
    }

    
    public static void main(String[] args) {
        Thread thread = new Thread(() -> counter ("Counter 1"));
        // new Thread(() -> counter ("Counter 1")).start();
        thread.start();

        
        //Scanner in = new Scanner (System.in);
        //System.out.print("how many counters:");
        //counter
    }
    
}
