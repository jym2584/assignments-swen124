package activities;

import java.util.Random;

public class Sleeper implements Runnable{
    
    private int seconds;

    public Sleeper(int seconds) {
        this.seconds = seconds;
    }
    
    @Override
    public void run() {
        System.out.println("Sleeping for " + seconds + " seconds.");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("I'm awake!");
        
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++) {
            threads[i]  = new Thread(new Sleeper(new Random().nextInt(10) + 1));
            threads[i].start();
        }

        for(int i = 0; i < 5; i++) {
            threads[i].join();
        }

        System.out.println("Everybody's awake!");
    }
}
