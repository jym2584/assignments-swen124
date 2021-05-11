package set;

import java.util.Iterator;
import java.util.*;

public class ListSet<E> implements Set<E> {
    private List<E> list;

    public ListSet() {
        list = new ArrayList<>();
 
    }

    /**
     * Time complexity: O(n)? Iterating through a list
     */
    @Override
    public Iterator<E> iterator() {
        return new ListSetIterator<>(list);
    }

    /* Using lambda expression
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public E next() {
                return list.get(index++);
            }

        };
    }
    */
    
    /**
     * Time Complexity: O(n)
     * Don't think it can have a faster time complexity since we need to make sure that the list doesn't contain the same value on a set
     */
    @Override
    public void add(E e) {
        if(!list.contains(e)) {
            list.add(e);
        }
    }

    /**
     * Time Complexity: O(n^2)
     * Don't think it can have a faster time complexity since we need to make sure that the list has contain the same value on a set before removing it
     * 
     * I think maybe the time complexity would be O(n) if we try to remove the value and catch any Exceptions if it can't
     * 
     * Something like:
     
        try {
            list.remove(e);
        } catch (Exception ex) {
            // do nothing
        }

        maybe...
     */
    @Override
    public void remove(E e) {
        if(list.contains(e)) {
            list.remove(e);
        }

        
    }

    /**
     * Time Complexity: has to be O(n) since we want to traverse through the list if a value exists
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * Time complexity: O(1) since we are just returning the size of the array
     */
    @Override
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        int[] values = {1, 3, 5, 2, 3, 1};

        Set<Integer> set = new ListSet<> ();
        for (int value : values) {
            set.add (value);
        }

        System.out.println("For each loop:");
        for(int numbers: set) {
            System.out.println(numbers);
        }

        System.out.println("Size: " + set.size());
    }
    
}
