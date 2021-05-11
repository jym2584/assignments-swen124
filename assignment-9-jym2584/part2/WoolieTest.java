package part2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * JUnit testing for setters
 */
@Testable
public class WoolieTest {
    @Test
    public void testGetters() {
        Woolie woolie = new Woolie("The Woolie", 5, "Pyongyang", new Bridge());
        assertEquals("The Woolie", woolie.getName());
        assertEquals(5, woolie.getTravelTime());
        assertEquals("Pyongyang", woolie.getDestination());
        assertEquals("Woolie {The Woolie, 5, Pyongyang}", woolie.toString());

    }
}
