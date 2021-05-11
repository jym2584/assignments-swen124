package ds;

import java.util.Iterator;
public class ArrayIterator<E> implements Iterator <E> {
    
    private E[] elements;
    private int index;
    private int size;

    public ArrayIterator (E[] elements, int size) {
        this.elements = elements;
        this.size = size;
        index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public E next() {
        E value = elements[index];
        index++;
        return value;
    }
}