package toys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * OUR TESTTSSSSSSSSSSSSSSSSSSSSSSSSSSSS
 */
@Testable
public class ToysTest {
    /**
     * Testing for product number equalities on various Toys
     */
    @Test
    public void toysEqualityTest() {
        Toy myrobot = new Robot("beep boop", 1234567, 50.23, true);
        Toy myrobot2 = new Robot("beep boop", 1234567, 50.11, true);
        Toy myrobot3 = new Doll("beep boop", 1234567, 50.23, "blue", "red");
        Toy myrobot4 = new ActionFigure("Peter Chan", 1234567, 50.23, "blue", "red", true);
        Toy myrobot5 = new Robot("Peter Chan", 1234568, 50.23);

        // Same product numbers
        assertEquals(myrobot, myrobot2);
        assertEquals(myrobot, myrobot3);
        assertEquals(myrobot, myrobot4);
        assertNotEquals(myrobot, myrobot5);
        // Different product numbers
        assertNotEquals(myrobot5, myrobot);
        assertNotEquals(myrobot5, myrobot2);
        assertNotEquals(myrobot5, myrobot3);
        assertNotEquals(myrobot5, myrobot4);
    }

    @Test
    public void robotPlayTest() { // Testing play function with charge depletion
        Toy myrobot = new Robot("beep boop", 1234567, 50.23, true);
        int expected = 0;

        for (int i = 0; i < 5; i++) {
            myrobot.play();
        }
        assertEquals(expected, ((Robot)myrobot).getCharge());
    }

    @Test
    public void robotChargeTest() { // Testing charge function 
        Toy myrobot = new Robot("beep boop", 1234567, 50.23, true);
        int expected = 0;
        int expected2 = 100;
        for (int i = 0; i < 10; i++) { // Checking if the expected is still 0 after trying to play with it 10 times (200 charge).
            myrobot.play();
        }
        assertEquals(expected, ((Robot)myrobot).getCharge());

        ((Robot)myrobot).charge(100);

        assertEquals(expected2, ((Robot)myrobot).getCharge());
    }
    @Test
    public void dollPlayTest() { // Testing play function
        Toy myrobot3 = new Doll("beep boop", 1234567, 50.23, "blue", "red");
        int expected = 0;

        for (int i = 0; i < 15; i++) { // Checking if the expected is still 0 after trying to play with it 15 times.
            myrobot3.play();
        }

        assertEquals(expected, ((Doll)myrobot3).getUses());
    }
    @Test
    public void actionFigurePlayTest() { // Testing play function and if the actionfigure has a grip
        Toy myrobot3 = new ActionFigure("beep boop", 1234567, 50.23, "blue", "red", true);
        int expected = 0;

        for (int i = 0; i < 15; i++) { // Checking if the expected is still 0 after trying to play with it 15 times.
            myrobot3.play();
        }

        assertEquals(expected, ((ActionFigure)myrobot3).getUses());
        assertEquals(true, ((ActionFigure)myrobot3).grip());
    }
}
