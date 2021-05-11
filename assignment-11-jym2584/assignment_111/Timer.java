package assignment_111;

import java.util.*;
/*
Results: 
    Took My(Array)List 9559770400 nanoseconds (about 9 seconds) to fill 100000000 values onto the list
    Took Anotha one (vectorlist) 13229909600 nanoseconds (about 13 seconds) to fill 100000000 values onto the list

The difference between arraylists and vectors in time differences is that vectors use synchronization in its add method
compared to arraylist which doesn't. 

Since arraylist is not thread safe, it generally is able to run faster since threads are not required to wait...
...while vectors do require threads to wait via synchronization 

 */
public class Timer {
    public static void fillList(String name, List<Integer> list, int numberOfValues) {
        long timeStart = System.nanoTime();
        for(int i = 0; i < numberOfValues; i++) {
            list.add(i);
        }
        long timeEnd = System.nanoTime();
        System.out.println(String.format("Took %s %d nanoseconds (about %d seconds) to fill %d values onto the list", name, timeEnd - timeStart, (timeEnd - timeStart) / 1000000000, numberOfValues));
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        List<Integer> vector = new Vector<>();
        int numberOfValues = 100000000;

        Thread threadList = new Thread( () -> {
            fillList("My(Array)List", list, numberOfValues);            
        });

        Thread threadVector = new Thread( () -> {
            fillList("Anotha one (vectorlist)", vector, numberOfValues);
        });

        threadList.start();
        threadList.join();
        threadVector.start();
    }

}
