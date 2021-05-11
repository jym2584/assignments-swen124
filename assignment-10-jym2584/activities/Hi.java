package activities;

public class Hi implements Runnable {
    @Override
    public void run() {
        System.out.println("Hi");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0 ; i < threads.length; i++) {
            threads[i] = new Thread(new Hi());
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Bye");
    }
}
