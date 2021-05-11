package ds;
import static org.junit.Assert.assertTrue;


import java.lang.IndexOutOfBoundsException;

import java.util.Iterator;
import java.lang.Iterable;


/**Linked List using Nodes
 * @Author Jin Moon
 */

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Our constructor
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    @Override
    public Iterator <E> iterator() {
        return new NodeIterator<>(head);
    }
    /**
     * Appends a value to the node
     * @param value takes in a value
     */
    public void append(E value) {
        Node<E> num = new Node<>(value);
        if (size == 0) {
            head = num;
            tail = num;
        } else {
            tail.setNext(num);
            tail = num;
        }
        size++;
    }

    /**
     * Grabs the value based on the index
     * @param index grabs an index
     * @return returns the value based on the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public E get(int index) {
        int count = 0;
        Node<E> next = head;
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        try {

            while (count < index) {
                next = next.getNext();
                count++;
            }
            return next.getValue();

        } catch (NullPointerException npe) {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * Sets the value of the index to a new one
     * @param index grabs the value of the index
     * @param value our value that we want to set to on that index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public void set(int index, E value) {
        try {    
            int count = 0;
            Node<E> next = head;
            while (count < index) {
                next = next.getNext();
                count++;
            }

            next.setValue(value);

        } catch (NullPointerException npe) {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * gets the size
     * @return integer size
     */
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i < 20; i += 2) {
            linkedList.append(i);
        }
        linkedList.set(3, 2000);
        for (int i = 0; i < linkedList.getSize(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
    
}
