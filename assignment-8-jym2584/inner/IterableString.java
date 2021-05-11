package inner;
import java.util.Iterator;

public class IterableString extends String implements Iterable<Character> {

    @Override
    public Iterator<Character> iterator() {
        return new StringIterator(this);
    }
    
}
