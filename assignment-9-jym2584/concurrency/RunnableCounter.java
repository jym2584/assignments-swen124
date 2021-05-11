package concurrency;

public class RunnableCounter implements Runnable{
    private String name;

    public RunnableCounter(String name) {
        this.name = name;

    }

    @Override
    public void run() {
        for ( int i = 1; i <= 100; i++) {
            System.out.println("Counter " + name + ":" + i);
        }
    }

    public static void main(String[] args) {
        Runnable myCounter = new CounterThread("1");
        Thread myThread = new Thread(myCounter);
        myThread.start();
        while (myThread.isAlive()) {
            // wait

        }


        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}