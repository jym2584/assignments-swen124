package ds;
import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue() {
        elements = (E[])new Object[4];
    }

    @Override
    public void enqueue(E value) {
        if (size == elements.length) {
            resize();
        }
        elements[back] = value;
        back = (back + 1) % elements.length;
        size++;
    }

    public void resize() {
        E[] bigger = (E[])new Object[size*2];
        for (int i = 0; i < size; i++) {
            bigger[i] = elements[front];
            front = (front + 1) % size;
        }
        elements = bigger;
        front = 0;
        back = size;
    }
    @Override
    public E dequeue() {
        if (size != 0) {
            E value = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            return value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");

        for(; queue.size() != 0;) {
            System.out.print(queue.dequeue() + " ");
        }
    }

}
