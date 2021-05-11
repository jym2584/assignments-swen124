package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class FibonacciTest {
    @Test
    public void testFibonacci45() {
        Fibonacci myrange = new Fibonacci(45);
        int value = 0 ;
        for (int num: myrange) {
            value = num;
        }

        assertEquals(myrange.get(45), value);
    }
}
