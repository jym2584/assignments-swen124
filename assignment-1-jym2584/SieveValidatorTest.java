import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * Test file for SieveValidator
 * 
 * @author Jin Moon
 */

@Testable
public class SieveValidatorTest {
    @Test
    public void sieve5() throws IOException { // Based on sieve_5.txt
        //setup
        int [] sieve5 = new int[5];
        sieve5[0] = 1;
        sieve5[1] = 1;
        sieve5[2] = 1;
        sieve5[3] = 0;
        sieve5[4] = 1;

        int [] expected = new int[5];
        expected[0] = 1;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;
        expected[4] = 1;

        int expectedCount = 1;
        // invoke
        int actualCount = SieveValidator.repairSieve(sieve5);

        assertEquals(Arrays.toString(expected), Arrays.toString(sieve5));
        assertEquals(expectedCount, actualCount);
    }
    @Test
    public void sieve10() throws IOException { // random numbers
        //setup
        int [] sieve10 = new int[10];
        sieve10[0] = 1;
        sieve10[1] = 0;
        sieve10[2] = 0;
        sieve10[3] = 0;
        sieve10[4] = 0;
        sieve10[5] = 0;
        sieve10[6] = 0;
        sieve10[7] = 0;
        sieve10[8] = 0;
        sieve10[9] = 0;

        int [] expected = new int[10];
        expected[0] = 1;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;
        expected[4] = 1;
        expected[5] = 0;
        expected[6] = 1;
        expected[7] = 0;
        expected[8] = 1;
        expected[9] = 1;

        int expectedCount = 5;
        // invoke
        int actualCount = SieveValidator.repairSieve(sieve10);

        assertEquals(Arrays.toString(expected), Arrays.toString(sieve10));
        assertEquals(expectedCount, actualCount);
    }

}
