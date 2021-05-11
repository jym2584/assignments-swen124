package ds;
import java.lang.Iterable;
import java.util.Iterator;


public interface List<E> extends Iterable<E> {


    @Override
    default Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
    void append(E value);
    E get(int index);
    void set(int index, E value);
    int size();


    
}
