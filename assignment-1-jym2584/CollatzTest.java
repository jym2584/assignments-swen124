import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class CollatzTest {
    
    @Test
    public void TestCollatz13() { // Testing a Collatz series
        // setup
        int n = 13;
        String expected = "13 40 20 10 5 16 8 4 2 1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze

        assertEquals(expected, actual);
    }

    @Test
    public void TestCollatz1() { // Testing a single digit string
        // setup
        int n = 1;
        String expected = "1";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze

        assertEquals(expected, actual);
    }

    @Test
    public void TestCollatz0() { // Testing empty string
        // setup
        int n = 0;
        String expected = "";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze

        assertEquals(expected, actual);
    }

    @Test
    public void TestCollatzNegative() { // Testing empty string w/ negative
        // setup
        int n = -100;
        String expected = "";

        // invoke
        String actual = Collatz.sequence(n);

        // analyze

        assertEquals(expected, actual);
    }
}
