package activities;

public interface Concatenator<E> {
    void add(E e);
    void remove(E e);
    String concat();
}