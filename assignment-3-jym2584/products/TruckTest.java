package products;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import toys.*;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * Testing methods for our Truck class
 */
@Testable
public class TruckTest {
    @Test
    public void truckTest() {
        Truck truck = new Truck(2);

        assertEquals(2, truck.getProducts().length);
    }
    @Test
    public void loadTruckTest() {
        Truck truck = new Truck(5);
        Product robot = new Robot("R2D2", 2345, 23.43, true);
        truck.load(robot);
        
        assertEquals(robot.getProductCode(), truck.getProducts()[truck.getProducts().length-1].getProductCode());
    }
    @Test
    public void unloadTruckTest() {
        Truck truck = new Truck(5);
        Product robot = new Robot("R2D2", 2345, 23.43, true);
        truck.load(robot);

        truck.unload();
        for (int i = 0; i < truck.getCapacity(); i++ ) {
            assertFalse(truck.getProducts()[i] != null, "Product exists at " + i + " (" + truck.getProducts()[i].getName() + ")");
        }

    }
}
