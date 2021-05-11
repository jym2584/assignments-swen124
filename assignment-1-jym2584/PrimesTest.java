import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PrimesTest {
    @Test
    public void TestIsPrime() { // Testing true
        // setup
        int n = 55;
        int m = 2;
        int o = 3;
        boolean expected = true;
        
        // invoke
        boolean actual = Primes.isPrime(n);
        boolean actual2 = Primes.isPrime(m);
        boolean actual3 = Primes.isPrime(o);

        // analyze

        assertEquals(expected, actual);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }
    
    @Test
    public void TestIsNotPrime() { // Testing false
        // setup
        int n = 56;
        int m = 0;
        int o = 1;
        boolean expected = false;
        
        // invoke
        boolean actual = Primes.isPrime(n);
        boolean actual2 = Primes.isPrime(m);
        boolean actual3 = Primes.isPrime(o);

        // analyze

        assertEquals(expected, actual);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }

    @Test
    public void TestNegativePrime() { // Testing negative, false
        // setup
        int n = -10;
        boolean expected = false;
        
        // invoke
        boolean actual = Primes.isPrime(n);

        // analyze

        assertEquals(expected, actual);
    }
}
