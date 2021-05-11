package ds;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Collections;

public class ListPQ implements Queue<Integer> {
    private LinkedList<Integer> aList;
    
    public ListPQ() {
        aList = new LinkedList<>();
    }

    @Override
    public void enqueue(Integer value) {
        aList.add(value);

    }

    @Override
    public Integer dequeue() {
        int lowest = aList.get(0);
        for(int i = 0; i < aList.size(); i++) {
            if (aList.get(i) < lowest) {
                lowest = aList.get(i);
            }
        }
        aList.removeFirstOccurrence(lowest);
        System.out.println("Removed " +lowest);
        return lowest;

    }

    @Override
    public int size() {
        return aList.size();
    }

    @Override
    public String toString() {
        return aList.toString();
    }

    public static void main(String[] args) {
        ListPQ list = new ListPQ();
        list.enqueue(2);
        list.enqueue(5);
        list.enqueue(1);
        list.enqueue(10);
        list.enqueue(7);
        list.enqueue(3);
        list.enqueue(15);
        list.enqueue(9);
        System.out.println("Actual List " + list.aList);
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        System.out.println("Actual List " + list.aList);
    }
    
}
