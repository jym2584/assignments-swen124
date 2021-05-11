package activities;

public class NameThread3 implements Runnable {
    private final String name;
    private final int index;
    private final Thread previous;

    public NameThread3(String name, int index, Thread previous) {
        this.name = name;
        this.index = index;
        this.previous = previous;
    }

    @Override
    public void run() {
        try {
            if(previous != null) {
                previous.join();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print(name.charAt(index));
    }

    public static void main(String[] args) throws InterruptedException {
        String name = "Bruce";
        Thread[] threads = new Thread[name.length()];
        threads[0] = new Thread(new NameThread3(name, 0, null));
        threads[0].start();
        for(int i =1; i < threads.length; i++) {
            threads[i] = new Thread(new NameThread3(name, i, threads[i-1]));
            threads[i].start();
            // threads[i].join(); waits for each thread to finish as we start them
        }

        for(int i =0; i< threads.length; i++) {
            threads[i].join(); // difference: threads above start at the same time, but this time we wait for each thread to finish
        }
        System.out.println("!");
    }
}
