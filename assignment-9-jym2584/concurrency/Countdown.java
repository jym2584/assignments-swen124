package concurrency;

public class Countdown implements Runnable {

    @Override
    public void run() {
        int i = -10;
        for(;;) {
            if (i == 0) {
                System.out.println("Liftoff");
            } else if (i < 0) {
                System.out.println("T" + i);
            } else {
                System.out.println(i);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                
            }

            i++;
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Countdown()).start();
    }
    
}
