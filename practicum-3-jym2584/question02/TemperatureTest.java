package question02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TemperatureTest {
    @Test
    public void testNegativeF() {
        // setup
        Temperature.TemperatureScale f2C = Temperature.createF2C();
        double fTemp = -20;
        double expected = -28.9;

        // invoke
        double actual = f2C.convert(fTemp);

        // analyze
        assertEquals(expected,actual,0.5);
    }

    @Test
    public void testZeroF() {
        // setup
        Temperature.TemperatureScale f2C = Temperature.createF2C();
        double fTemp = 0;
        double expected = -17.7;

        // invoke
        double actual = f2C.convert(fTemp);

        // analyze
        assertEquals(expected,actual,0.5);
    }

    @Test
    public void testPositiveF() {
        // setup
        Temperature.TemperatureScale f2C = Temperature.createF2C();
        double fTemp = 212;
        double expected = 100;

        // invoke
        double actual = f2C.convert(fTemp);

        // analyze
        assertEquals(expected,actual,0.5);
    }

    @Test
    public void testNegativeC() {
        // setup
        Temperature.TemperatureScale c2F = Temperature.createC2F();
        double cTemp = -20;
        double expected = -4;

        // invoke
        double actual = c2F.convert(cTemp);

        // analyze
        assertEquals(expected,actual,0.5);
    }

    @Test
    public void testZeroC() {
        // setup
        Temperature.TemperatureScale c2F = Temperature.createC2F();
        double cTemp = 0;
        double expected = 32;

        // invoke
        double actual = c2F.convert(cTemp);

        // analyze
        assertEquals(expected,actual,0.5);
    }

    @Test
    public void testPositiveC() {
        // setup
        Temperature.TemperatureScale c2F = Temperature.createC2F();
        double cTemp = 100;
        double expected = 212;

        // invoke
        double actual = c2F.convert(cTemp);

        // analyze
        assertEquals(expected,actual,0.5);
    }
}
