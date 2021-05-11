package activities;

public class Wait implements Runnable {
    private final Object lock;
    private int id;
    public Wait(Object lock, int id) {
        this.lock = lock;
        this.id = id;
    }

    @Override
    public void run() {
            System.out.println(id + " Something");
    }    

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        int numThreads = 10;
        Thread[] threads = new Thread[numThreads];

        for(int i = 0; i < threads.length; i++) {
        threads[i] = new Thread(new Wait(lock, i));
        threads[i].start();
        }

        Thread.sleep(1);
        synchronized(lock) {
            lock.notifyAll();
        }
    }
    
}
