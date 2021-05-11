package ds;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapPQ implements Queue<Integer> {
    private ArrayHeap array;

    public HeapPQ() {
        array = new ArrayHeap();
    }
    @Override
    public void enqueue(Integer value) {
        array.add(value);
    }

    @Override
    public Integer dequeue() {
        int num = array.remove();
        return num;
    }

    @Override
    public int size() {
        return array.size();
    }
    @Override
    public String toString() {
        return array.toString();
    }

    public int[] getArray() {
        return array.getArray();
    }
    public static void main(String[] args) {
        HeapPQ heap = new HeapPQ();
        for(int i = 5; i >= 1; i--) {
            heap.enqueue(i);
            System.out.println("Added " + i + " heap : " + heap.array);
        }

        for(int i = 0; i < 5; i++) {
            System.out.println("Removed " + heap.dequeue() + " heap: " + heap.array);
        }
    }
}
