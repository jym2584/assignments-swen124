package activities;

import java.util.*;

public class Consumer implements Runnable {
    private final LinkedList <String> queue;
    private final int id;

    public Consumer (LinkedList <String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(queue) {
                if(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException ie) {}
                } else {
                    System.out.println(id + ": " + queue.remove(0));
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList <String> queue = new LinkedList<>();
        queue.add("Hello");
        queue.add("Goodbye");
        Thread consumer = new Thread (new Consumer(queue,0));
        consumer.start();
    
    }

    
}