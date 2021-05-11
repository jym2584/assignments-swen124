package concurrency;
import java.util.*;

public class ListAdder implements Runnable{
    private List<Integer> sharedList;
    private int num;

    public ListAdder(List<Integer> sharedList, int num) {
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for(int i = 0; i < num; i++) {
            sharedList.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * Most java statements take multiple cpu cycles to execute
         *  - This can be problematic when multiple threads are using the same shared resource
         * 
         * sharedList was the shared resource
         *  - Thus between retrieving a value and using that value the active may change
         *      - Known as context switch
         * 
         * The share value can be changed without the original thread knowing, making the usage incorrect
         *  - This issue is known as race condition since all the threads are racing to try and use/update the shared resource
         */
        List<Integer> sharedList = new ArrayList<>(); // shared resource (problematic if multiple threads are using the same shared resource)
        int num = 100;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread (new Thread(new ListAdder(sharedList, 50)));
            threads[i].start();
        }

        for(int i = 0; i < num; i++) {
            threads[i].join();
        }

        System.out.println("List has " + sharedList.size() + " entries");
    }
    
}
