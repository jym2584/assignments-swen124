package activities;
import java.util.*;

public class TheCount implements Runnable {
    public static final int[] COUNT = new int[1];
    public static final Object lock = new Object();
    // public Object lock = new Object();       each thread has its own lock instead of sharing
    public static final int STOP = 1000000; 
    private String id;

    public TheCount(String id) {
        this.id = id;
    }

    @Override
    public void run() {
            System.out.println(id + " is starting count.");
            for(int i = 0; i < STOP; i++) {
                synchronized(lock) { // runs slower, but prevents the thread from overlapping each other
                    COUNT[0]++;
                }
            }
            System.out.println(id + " finished counting.");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            threads.add(new Thread(new TheCount("" + i))); // want to go to office hour about this
            threads.get(i).start();
            //threads.get(i).join();
        }

        /*
        Thread thread = new Thread(new TheCount("1"));
        thread.start();

        Problems with doing .sleep in this scenario():
            - doesn't always add up to 1,000,000
            - if we increase the ms, will take long

        Thread.sleep(1000); 
        */
        Thread.sleep(1000); 
        System.out.println("The count = " + TheCount.COUNT[0]);

    }
}
