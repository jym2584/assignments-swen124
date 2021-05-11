package ds;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Math;
import java.lang.Iterable;
/**
 * Range Iterator in a class format
 */
public class IntRange implements Range {
    private int start;
    private int stop;
    private int step;

    /**
     * int constructor
     * @param start starting value
     * @param stop ending value
     * @param step increment
     */
    public IntRange(int start, int stop, int step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }
    
    /**
     * adding default step to 1
     * @param start starting value
     * @param stop ending value
     */
    public IntRange(int start, int stop) {
        this(start, stop, 1);
    }

    /**
     * our incrementing
     */
    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(start, stop, step);
    }

    /**
     * Handles size if there are any odd values 
     */
    @Override
    public int size() {
        int size;
        if ((stop - start) % step == 0) {
            size = (stop - start) / step;
        } else {
            size = ((stop - start) / step) + 1; 
        }
        return size;
    }

    /**
     * Grab value at index
     */
    @Override
    public int get(int index) {
        int nextValue = 0;
        int indexTemp = 0;
        int value = nextValue + start;
        while ((nextValue + start) < stop && (indexTemp < index)) {
            value = nextValue + start;
            nextValue = nextValue + step;
            indexTemp++;
        }
        return value;
    }

    public static void main(String[] args) {

        IntRange myrange = new IntRange(1, 11, 3);
        System.out.println("Size = " + myrange.size());
        for (int num: myrange) {
            System.out.println(num);
        }
        System.out.println();
        IntRange myrange2 = new IntRange(2, 53, 7);
        System.out.println("Size = " + myrange2.size());
        for (int num: myrange2) {
            System.out.println(num);
        }
        System.out.println();
        IntRange myrange3 = new IntRange(1, 10, 1);
        System.out.println("Size = " + myrange3.size());
        for (int num: myrange3) {
            System.out.println(num);
        }

        System.out.println(myrange2.get(8));



    }
}
