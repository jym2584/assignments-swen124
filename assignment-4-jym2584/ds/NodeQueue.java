package ds;

public class NodeQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue() {
        size = 0;
        front = null;
        back = null;
    }

    @Override
    public void enqueue(E value) {
        Node<E> node = new Node<>(value);

        if (size == 0) {
            front = node;
            back = node;
        } else {
            back.setNext(node);
            back = node;
        }

        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0)  {
            return null;
        }

        E value = front.getValue();
        front = front.getNext();
        size--;

        if (front == null) {
            back = null;
        }

        return value;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new NodeQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);

        for(; queue.size() != 0;) {
            System.out.print(queue.dequeue() + " ");
        }
    }

}
