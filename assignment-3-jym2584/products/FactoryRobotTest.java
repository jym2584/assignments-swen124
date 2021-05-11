package products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import toys.*;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * Testing methods for our FactoryRobot class
 */
@Testable
public class FactoryRobotTest {
    @Test
    public void factoryRobotTest() {
        FactoryRobot myrobotfactory = new FactoryRobot();
        Product myrobot = myrobotfactory.manufacture();


        // I'm not sure how to test for random name/color/msrp/product code using seed but this should prove that the robot does exist?
        assertEquals(100, ((Robot)myrobot).getCharge());
    }
}
