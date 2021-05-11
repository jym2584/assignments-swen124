package assignment_101;
import java.util.*;
/**
 * Ignore this class. Having trouble with creating inner classes, wanted to get a bit of help for this
 */

public class EvensAndOdds2 {

    public static class Odds implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 99; i += 2) {
                System.out.println(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }

    public static class Evens implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                System.out.println(i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }



    public static void main(String[] args) throws InterruptedException {
        Thread threadOdds = new Thread(new EvensAndOdds2.Odds());
        Thread threadEvens = new Thread(new Evens());
        threadOdds.start();
        Thread.sleep(10);
        threadEvens.start();
    }    
}
