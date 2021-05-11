package concurrency;

import java.util.Scanner;

public class Counters {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner (System.in);
        System.out.print("how many counters:");
        int num = in.nextInt();

        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread (new RunnableCounter(i +""));
            threads[i].start();
        }

        for(int i = 0; i < num; i++) {
            threads[i].join();
        }


        in.close();
        System.out.println("Job's Done");

    }
    
}