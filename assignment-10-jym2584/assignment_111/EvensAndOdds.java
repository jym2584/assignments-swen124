package assignment_111;

public class EvensAndOdds {
    public static class Odds extends Thread {
        private final Object lock;

        public Odds(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized(lock) {
                try {
                    for(int i = 1; i <= 99; i+=2) {
                        System.out.println(i);
                        lock.notify();
                        if(i == 99) {
                            break;
                        }
                        lock.wait();
                    }
                } catch(InterruptedException ie) {}
            }
        }
    }

    public static class Evens extends Thread {
        private final Object lock;

        public Evens(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized(lock) {
                try {
                    for(int i = 2; i <= 100; i+=2) {
                        System.out.println(i);
                        lock.notify();
                        if(i == 100) {
                            break;
                        }
                        lock.wait();
                    }
                } catch(InterruptedException ie) {}
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread odds  = new EvensAndOdds.Odds(lock);
        Thread evens = new EvensAndOdds.Evens(lock);

        odds.start();
        Thread.sleep(10);
        evens.start();
    }
}
