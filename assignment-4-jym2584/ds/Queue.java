package ds;

public interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    int size();
}