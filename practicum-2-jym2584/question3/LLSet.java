package question3;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Complete the following Set implementation. The set 
 * is built on the JCF LinkedList.
 * 
 * Several methods have been implemented for you which 
 * can be used as a reference for the various parameters.
 * 
 * Test code has been provided for you in main.
 * 
 */

public class LLSet<E> implements Set<E> {
    private List<E> contents;

    public LLSet(){
        contents = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return contents.isEmpty();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(E e) {
        if(contents.contains(e)) { // If the element already exists on the set
            return false;
        } else {
            contents.add(e); // Add it otherwise
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        return contents.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return contents.contains(o);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(contents.containsAll(c)) { // If there are already elements on the list
            return false;
        }

        List<E> copy = new LinkedList<>();
        copy.addAll(c);

        for(int i = 0; i < c.size(); i++) {
            if(!contents.contains(copy.get(i))) { // Preventing duplicates
                contents.add(copy.get(i)); // Add non-duplicates to the set 
            }
        }
        return contents.containsAll(c); // returns true otherwise
    }

    @Override
    public String toString() {
        return contents.toString();
    }

    // The following methods have been implemented for you
    // due to their simplicity and somewhat rarer usage
    // in class or activities.

    @Override
    public void clear() {
        contents = new LinkedList<>();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return contents.containsAll (c);
    }
     
    @Override
    public boolean removeAll(Collection<?> c) {
        return contents.removeAll (c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return contents.retainAll (c);
    }

    @Override
    public Object[] toArray() {
        return contents.toArray ();
    }

    @Override
    public Iterator<E> iterator() {
        return contents.iterator();
    }

    // The following method does NOT need to be completed.

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Expected output for the following test:
     * LL Set
     * true
     * [Foo, Bar]
     * 2
     * false
     * true
     * true
     * [Bar]
     * [Foo]
     * true
     * false
     * [Foo, 1, 2, 3, 4]
     * true
     * true
     * false
     * [Foo]
     * true
     * true
     * [1, 2, 3, 4]
     * 1
     * 2
     * 3
     * 4
     * 
     */
    public static void main(String[] args) {
        List<String> strList = new LinkedList<>();
        for (int i = 1; i < 5; i++){
            strList.add(Integer.toString(i));
            strList.add(Integer.toString(i));
        }


        System.out.println();
        System.out.println("LL Set");
        LLSet<String> llSet = new LLSet<>();
        System.out.println(llSet.isEmpty());
        llSet.add("Foo");
        llSet.add("Foo");
        llSet.add("Bar");
        System.out.println(llSet);
        System.out.println(llSet.size());
        System.out.println(llSet.isEmpty());
        System.out.println(llSet.contains("Foo"));
        System.out.println(llSet.contains("Bar"));
        llSet.remove("Foo");
        System.out.println(llSet);
        llSet.clear();
        llSet.add("Foo");
        System.out.println(llSet);
        System.out.println(llSet.addAll(strList));
        System.out.println(llSet.addAll(strList));
        System.out.println(llSet);
        System.out.println(llSet.containsAll(strList));
        System.out.println(llSet.removeAll(strList));
        System.out.println(llSet.removeAll(strList));
        System.out.println(llSet);
        llSet.clear();
        llSet.add("Foo");
        System.out.println(llSet.addAll(strList));
        System.out.println(llSet.retainAll(strList));
        System.out.println(llSet);
        for(String ele : llSet){
            System.out.println(ele);
        }
    }
}

