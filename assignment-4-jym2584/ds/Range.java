import java.util.Iterator;
/**
 * Range interface 
 */
public interface Range extends Iterable<Integer> {
    int size();
    int get(int index);
    Iterator<Integer> iterator();
}