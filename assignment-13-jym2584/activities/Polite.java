package activities;

public class Polite extends Thread {
    private String message;
    private Object lock;

    public Polite (String message, Object lock) {
        this.message = message;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            synchronized(lock) {
                try {
                    lock.wait();
                System.out.println(message);
                lock.notify();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Polite polite1 = new Polite("What did you say?", lock);
        Polite polite2 = new Polite("What?", lock);

        polite1.start();
        polite2.start();

        Thread.sleep(1);
        synchronized(lock) {
            lock.notify();
        }
    }
}
