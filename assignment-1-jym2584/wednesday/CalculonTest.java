import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

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
}