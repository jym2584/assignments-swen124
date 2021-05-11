package ds;
import java.util.Iterator;
import java.lang.Math;


public class FibonacciIterator implements Iterator<Integer> {
    private int fn_1;
    private int fn_2;
    private int num;
    private int nextValue;
    private int fn_1Next;
    private int index;

    
    public FibonacciIterator(int num) {
        this.num = num;
        this.fn_1 = 1;
        this.fn_2 = 0;
        this.fn_1Next = 1;
        this.index = 0;
        this.nextValue = 0;
    }

    @Override
    public boolean hasNext() {
        return index <= num;
    }

    @Override
    public Integer next() {
        if (index == 1) {
            index++;
            return 1;
        } else if (index == 0) {
            index++;
            return 0;
        } else {
            int temp = fn_1;
            fn_1 = fn_1 + fn_2;
            fn_2 = temp;
            index++;
            return fn_1;
        }
    }
}
