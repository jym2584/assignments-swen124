package activities;
import java.util.*;

public class Deadlocker extends Thread{
    private Queue<String> worker;
    private Queue<String> coworker;
    private Random random;
    private int count;

    public Deadlocker() {
        worker = new LinkedList<>();
        coworker = new LinkedList<>();
        random = new Random();
        count = 0;
        worker.add("Part " + random.nextInt(5));
    }

    private void worker() {
        synchronized(worker) {
            synchronized(coworker) {
                if(!worker.isEmpty()) {
                    String item = worker.remove();
                    coworker.add(item);
                    System.out.println(count);
                    count++;
                }
            }
        }
    }

    
    private void coworker() {
        synchronized(coworker) {
            synchronized(worker) {
                if(!coworker.isEmpty()) {
                    String item = coworker.remove();
                    worker.add(item);
                    System.out.println(count);
                    count++;
                }
            }
        }
    }


    @Override
    public void run() {
        while(true) {
            worker();
            coworker();
        }
    }

    public static void main(String[] args) {
        Deadlocker deadlock = new Deadlocker();
        deadlock.start();
    }

}
