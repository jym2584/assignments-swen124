package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class HeapPQTest {
    @Test
    public void testHeapPQ(){
        HeapPQ heap = new HeapPQ();
        for(int i =1; i <= 5; i++) {
            heap.enqueue(i);
            System.out.println("Added " + i + " heap : " + heap);
            assertEquals(i, heap.getArray()[i-1]);
        }
        assertEquals(5, heap.size());
        for(int i =1; i <= 5; i++) {
            assertEquals(i, heap.dequeue());
        }
        assertEquals(0, heap.size());
    }
}
