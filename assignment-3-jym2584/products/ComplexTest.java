package products;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * Testing methods for our Complex class
 */
@Testable
public class ComplexTest {
    @Test
    public void complexTest() {
        Complex complex = new Complex(2,2);
        complex.populateComplex();
        
        assertEquals("[A Robot Factory, A Robot Factory, A Doll Factory, A Doll Factory]", Arrays.toString(complex.getFactories()));
    }
    @Test
    public void loadTruckTest() {
        Random random = new Random(1);
        Complex complex = new Complex(2,2);
        complex.populateComplex();
        Truck truck = new Truck(5);
        complex.loadTruck(truck);
        
        for (int i = 0; i < truck.getCapacity(); i++ ) {
            assertTrue("Product exists at " + i + " (" + truck.getProducts()[i].getName() + ")", truck.getProducts()[i] != null);
        }
    }
    @Test
    public void unloadTruckTest() {
        Random random = new Random(1);
        Complex complex = new Complex(2,2);
        complex.populateComplex();
        Truck truck = new Truck(5);

        complex.loadTruck(truck);
        for (int i = 0; i < truck.getCapacity(); i++ ) {
            assertTrue("Product exists at " + i + " (" + truck.getProducts()[i].getName() + ")", truck.getProducts()[i] != null);
        }

        complex.unloadTruck(truck);
        for (int i = 0; i < truck.getCapacity(); i++ ) {
            assertFalse(truck.getProducts()[i] != null, "Product exists at " + i + " (" + truck.getProducts()[i].getName() + ")");
        }

    }
}
