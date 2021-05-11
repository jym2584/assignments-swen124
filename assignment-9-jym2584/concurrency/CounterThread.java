package concurrency;

public class CounterThread extends Thread {
    public String name;

    public CounterThread (String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            System.out.println("Counter " + name + ":" + i);
        }
        System.out.println("Counter " + name + " done.");
    }
    public static void main(String[] args) throws InterruptedException {
        Thread counter = new CounterThread("1");
        counter.start();
        int i = 0;

        while (counter.isAlive()) {
            i++;

            try {
            Thread.sleep(50);
            } catch (InterruptedException ie) {}
            
        }


        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();
        System.out.println("Checked alive " + i + " times");
    }
}