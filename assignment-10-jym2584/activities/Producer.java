package activities;

import java.util.*;

public class Producer implements Runnable {
    private final LinkedList <String> queue;
    private final int id;

    public Producer (LinkedList <String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(true) {
            try {
                Thread.sleep(250); 
            } catch (InterruptedException e) {}
            
                synchronized(queue) {
                    for(int i = 0; i < rand.nextInt(5); i++) {
                        queue.add("Producer" + id + ": " + i);
                    }
                    queue.notify();
                }
        }
    }

    public static void main(String[] args) {
        LinkedList <String> queue = new LinkedList<>();
        Thread[] consumers = new Thread[5];
        Thread[] producers = new Thread[5];
        for(int i = 0; i < consumers.length; i++ ) {
            consumers[i] = new Thread(new Consumer(queue, i));
            consumers[i].start();
        }

        for(int i = 0; i < producers.length; i++ ) {
            producers[i] = new Thread(new Producer(queue, i + 100));
            producers[i].start();
        }

    }
}