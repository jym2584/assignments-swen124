package activities;

public class Incrementor {
    public int count;
    public Incrementor() {
        count = 0;
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];


        Incrementor increment = new Incrementor();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable(){
                @Override
                public void run() {
                        for(int i = 0; i < 100000; i++) {
                            increment.increment();
                        }
                }
            });

            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(increment.getCount());


    }
}
