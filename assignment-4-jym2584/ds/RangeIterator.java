package ds;
import java.util.Iterator;
import java.lang.Math;

/**
 * Range Iterator using start, stop and step
 */
public class RangeIterator implements Iterator<Integer> {
    private int start;
    private int stop;
    private int step;
    private int index;
    private int nextValue;

    /**
     * our range iterator
     * @param start starting value
     * @param stop ending value
     * @param step increments
     */
    public RangeIterator(int start, int stop, int step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
        this.index = 0;
        this.nextValue = 0;
    }

    /**
     * returns if the next value can be called
     */
    @Override
    public boolean hasNext() {
        return (nextValue + start) < stop;
    }

    /**
     * Our iterator, returns the next value
     */
    @Override
    public Integer next() {
        int value = nextValue + start;
        nextValue = nextValue + step;
        index++;
        return value;
    }
}
