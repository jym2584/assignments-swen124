package ds;

import java.util.Iterator;
/**
 * Fibonacci using Iterators
 */
public class Fibonacci implements Range {
    private int n;

    /**
     * 
     * @param n calls for a number
     */
    public Fibonacci(int n)  {
        this.n = n;
    }


    /**
     * returns the numerical value of n (?)
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Gets the value of the fibonacci at an index
     */
    @Override
    public int get(int index) {
        IntRange ourRange = new IntRange(1, index);
        if(index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        }
        int fn_1 = 1;
        int fn_2 = 0;

        for(int element: ourRange) {
            int temp = fn_1;
            fn_1 = fn_1 + fn_2;
            fn_2 = temp;
        }
        return fn_1;
    }

    /**
     * Uses Fibonacci Iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(n);
    }

    public static void main(String[] args) {
        Fibonacci myrange = new Fibonacci(45);
        System.out.println("Size = " + myrange.size());
        int index = 0;
        for (int num: myrange) {
            System.out.println("Index = " + index + ": " +num);
            index++;
        }
        System.out.println();
        System.out.println("Get 45 = " + myrange.get(45));
    }
}
