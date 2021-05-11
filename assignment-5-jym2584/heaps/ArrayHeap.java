package heaps;

import java.util.Arrays;


public class ArrayHeap implements Heap{

    private int size;
    private int[] array;

    public ArrayHeap() {
        array = new int[3];
        size = 0;
    }
    private void swap(int a, int b) {
        if (array[a] != array[b]) {
            int temp = array[b];
            array[b] = array[a];
            array[a] = temp;
        }
    }
    @Override
    public String toString(){
        return Arrays.toString (array) + " " + (size);
    }

    @Override
    public void add (int value) {
        if (size == array.length){
           array = Arrays.copyOf(array, size * 2);
        }


        array[size] = value;

        int child = size;
        int parent = (child - 1) / 2;
        while (array [parent] > array [child] ) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;

        }

        size++;

    }

    @Override
    public int remove() {
        int temp = array[0];
        swap(0, size - 1);
        array[size - 1] = 0;
        size--;


        int parent = 0;
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        while (parent < size) {
            if (right < size) {
                if (array[right] < array[left]) {
                    if(array[right] < array[parent]) { 
                        swap(parent, right);
                        parent = right;
                    } else {
                        break;
                    }
                } else {
                    if(array[left] < array[parent]) {
                        swap(parent, left);
                        parent = left;
                    } else {
                        break;
                    }
                }
            } else if (left < size) {
                swap(parent, left);
                parent = left;
            } else {
                break;
            }

            left = parent * 2 + 1;
            right = parent * 2 + 2;
        
        }

        return temp;

    }
    
    public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap();
        System.out.println(heap);

        heap.add(8);
        heap.add(4);
        heap.add(12);
        heap.add(2);
        heap.add(7);

        System.out.println(heap);

        heap.remove();
        heap.remove();
        heap.remove();

        System.out.println(heap);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}