package ds;

public class Node <E> {
    private E value;
    private Node <E> next;

    public Node (E value) { // Node<E> isn't a type on the constructor                      
        this (value, null);
        next = null;
    }
    public Node (E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
    public E getValue() {
        return this.value;
    }
    public void setNext(Node <E> next) {
        this.next = next;
    }

    public Node <E> getNext() {
        return next;
    }

    public void setValue(E value) {
        this.value = value;
    }
    @Override
    public String toString(){
        return value.toString();
    }
    public static void main(String[] args){
        Node<String> a = new Node<>("Hello");
        Node<String> b = new Node<>("SWEC", a);

        System.out.println(b.getNext() + " " + b);
    }
}