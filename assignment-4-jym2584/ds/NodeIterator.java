package ds;

import java.util.Iterator;
import java.lang.Iterable;

public class NodeIterator<E> implements Iterator<E> {
    private Node<E> node;
    
    public NodeIterator (Node<E> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public E next() {
        E value = node.getValue();
        node = node.getNext();
        return value;
    }


}
