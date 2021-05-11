package ds;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Iterable;


public class ArrayList<E> implements List<E>{
    private Object[] elements;
    private int size = 0;

    public ArrayList() {
        elements = new Object[2];
        //size = 0;
    }
    @Override
    public void append(E value) {
        if (size == elements.length) {
            resize();
        }
        elements[size] = value;
        size++;

    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>((E[])elements, size);
    }

    public void resize() {
        elements = Arrays.copyOf(elements, size*2);
    }

    @Override
    public E get(int index) {
        return (E)elements[index];
    }

    @Override
    public void set(int index, E value) {
        elements[index] = value;

    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i += 2) {
            list.append(i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    
}
