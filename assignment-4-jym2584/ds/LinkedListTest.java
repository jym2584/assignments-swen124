package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class LinkedListTest {
    @Test
    public void testAppend() {
        int expected = 4;
        
        LinkedList<Integer> actual = new LinkedList<>();
        actual.append(4);

        assertEquals(1, actual.getSize());
        assertEquals(expected, actual.get(0));
    }

    @Test
    public void testGet() {
        String expected = "abc";

        LinkedList<String> actual = new LinkedList<>();
        actual.append("123");
        actual.append("abc");

        assertEquals(2, actual.getSize());
        assertEquals(expected, actual.get(1));
    }
    @Test
    public void testSet() {
        String expected = "def";

        LinkedList<String> actual = new LinkedList<>();
        actual.append("123");
        actual.append("abc");

        actual.set(1, expected);
        
        assertEquals(2, actual.getSize());
        assertEquals(expected, actual.get(1));
    }
}
