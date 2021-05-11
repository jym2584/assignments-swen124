import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
// package Calculon;

@Testable
public class CalculonTest {

    @Test
    public void testAdd() {
        //setup
        float x = 3.5f;
        float y = 7;
        float expected = 10.5f;

        // invoke
        float actual = Calculon.add(x, y);

        // analyze

        assertEquals(expected, actual);
        
    }
    @Test
    public void testSubtract() {
        //setup
        float x = 10;
        float y = 5;
        float expected = 5.0f;

        // invoke
        float actual = Calculon.subtract(x, y);

        // analyze

        assertEquals(expected, actual);
        
    }
    @Test
    public void testMultiply() {
        //setup
        float x = 2;
        float y = 5;
        float expected = 10.0f;

        // invoke
        float actual = Calculon.multiply(x, y);

        // analyze

        assertEquals(expected, actual);
        
    }
    @Test
    public void testDivide() {
        //setup
        float x = 10;
        float y = 2;
        float expected = 5.0f;

        // invoke
        float actual = Calculon.divide(x, y);

        // analyze

        assertEquals(expected, actual);
        
    }
    @Test
    public void testRaise() {
        //setup
        float x = 2;
        float y = 4;
        float expected = 16.0f;

        // invoke
        float actual = Calculon.raise(x, y);

        // analyze

        assertEquals(expected, actual);
        
    }

}