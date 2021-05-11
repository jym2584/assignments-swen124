package ds;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class IntRangeTest {
    @Test
    public void testRangeStep3() {
        IntRange myrange = new IntRange(1, 11, 3);
        int value = 0;
        for (int num: myrange) {
            value = num;
        } 

        assertEquals(4, myrange.size());
        assertEquals(10, myrange.get(4));
    }
    @Test
    public void testRangeStep3Index2() {
        IntRange myrange = new IntRange(1, 11, 3);
        int value = 0;
        for (int num: myrange) {
            value = num;
            if(value == myrange.get(2)) {
                break;
            }
        } 

        assertEquals(4, myrange.size());
        assertEquals(4, myrange.get(2)); // get value at index 2
    }
    @Test
    public void testRangeStep1() {
        IntRange myrange = new IntRange(1, 11);
        int value = 0;
        for (int num: myrange) {
            value = num;
            if(value == myrange.get(10)) {
                break;
            }
        } 

        assertEquals(10, myrange.size());
        assertEquals(10, myrange.get(10));
    }
}
