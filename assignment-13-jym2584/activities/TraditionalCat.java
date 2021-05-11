package activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraditionalCat<E> implements Concatenator<E>, Iterable<E> {
    private List<E> list;
    
    public TraditionalCat() {
        list = new ArrayList<>();
    }

    @Override
    public void add(E e) {
        list.add(e);
    }

    @Override
    public void remove(E e) {
        list.remove(e);
    }

    @Override
    public String concat() {
        String result = "";
        for (E value : list) {
            result += value;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Caterator<>(list);
    }

    public static void main(String[] args) {
        TraditionalCat<String> list = new TraditionalCat<>();
        list.add("Kim");
        list.add("Jong");
        list.add("Un");
        System.out.println(list.concat());

        for (String value : list) {
            System.out.println(value);
        }
    }
    
}
