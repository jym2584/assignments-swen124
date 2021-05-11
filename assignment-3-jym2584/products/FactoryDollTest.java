package products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import toys.*;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * Testing methods for our FactoryDoll class
 */
@Testable
public class FactoryDollTest {
    @Test
    public void factoryDollTest() {
        FactoryDoll mydollfactory = new FactoryDoll();
        Product mydoll = mydollfactory.manufacture();


        // I'm not sure how to test for random name/color/msrp/product code using seed but this should prove that the doll does exist?
        assertEquals(10, ((Doll)mydoll).getUses());
    }
}
