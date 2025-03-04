package activities;

import java.util.Iterator;
import java.util.List;

public class Caterator<E> implements Iterator<E> {
    private List<E> list;
    private int index;

    public Caterator(List<E> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        E value = list.get(index);
        index++;
        return value;
    }
    
}
