package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class ListPQTest {
    @Test
    public void testListPQ() {
        ListPQ list = new ListPQ();
        list.enqueue(2);
        list.enqueue(5);
        list.enqueue(1);
        list.enqueue(10);
        list.enqueue(7);
        list.enqueue(3);
        list.enqueue(15);
        list.enqueue(9);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals(1, list.dequeue());
        assertEquals(2, list.dequeue());
        assertEquals(3, list.dequeue());
        assertEquals(5, list.dequeue());
        assertEquals(7, list.dequeue());
        assertEquals(9, list.dequeue());
        assertEquals(10, list.dequeue());
        assertEquals(15, list.dequeue());
    }
}
