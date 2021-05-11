package assignment_101;
import java.util.*;

public class EvensAndOdds {
    private static final int SLEEPTIME = 50;

    public static void main(String[] args) {
        Thread threadOdds = new Thread( () -> {
            for (int i = 1; i <= 99; i += 2) {
                System.out.println(i);
                try {
                    Thread.sleep(SLEEPTIME); } catch (InterruptedException e) {}
            }
        });

        Thread threadEvens = new Thread( () -> {
            for (int i = 2; i <= 100; i += 2) {
                System.out.println(i);
                try {
                    Thread.sleep(SLEEPTIME); } catch (InterruptedException e) {}
            }
        });


        threadOdds.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        threadEvens.start();
    }    
}
