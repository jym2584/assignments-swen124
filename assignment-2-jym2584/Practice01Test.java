import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class Practice01Test {
    @Test
    public void testArrayToString() {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        String expected = Arrays.toString(array);

        String actual = Practice01.arrayToString(array);

        assertEquals(expected, actual);

    }

    @Test
    public void testArrayToString2() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 1;
        array[2] = 100;
        array[3] = 26;
        array[4] = 22;
        String expected = Arrays.toString(array);

        String actual = Practice01.arrayToString(array);

        assertEquals(expected, actual);

    }

}
