package toys;
import products.*;

/**
 * Polymorphism is used in the simulation by this tree:
 *          Complex ---------       (Used to load items of the Product onto the truck from several factories)
 *            |             |
 *            |            Truck    (Used to load/unload items of the Product given the cargo's size)
 *            |
 *         Factory                  (Used to manufacture items of the Product)
 *            |
 *         Product                  (Basic product information such as name, productCode and MSRP)
 *            |
 *          Toys _____              (Our type of Product)
 *            |       |
 *          Doll    Robot           (Our item types of Toys)
 *            |
 *      Action Figure               (Our type of Doll)
 * 
 * Since Product is a parent of other product types, you can easily create a new Product by creating a sub-parent of (that extends from) Product and then you are able
 * to create items of that product type. No implementation should be needed beyond creating a new abstract class that extends from the Product class since the 
 * Complex, Factory and Truck classes require the Product type to be passed in.
 * 
 * Tree representation of adding a new product
 *          Complex ---------
 *            |             |
 *            |            Truck
 *            |
 *         Factory 
 *            |
 *         Product -----------
 *            |              |
 *          Toys _____      New Product Type __________
 *            |       |         |                      |
 *          Doll    Robot   Item type 1           Item type 2
 *            |                 |
 *      Action Figure     Item sub-type 1
 * 
 */
public class Main {
    public static void main(String[] args) {
        // 7a. Complex with factories
        Complex complex = new Complex(2, 2);
        complex.populateComplex();

        // 7b. The empty truck
        Truck mytruck = new Truck(5);

        // 7c. Loading the truck at the complex
        System.out.println("---------------------------------------------------------------------");
        complex.loadTruck(mytruck);
        System.out.println("---------------------------------------------------------------------");

        // 7d. Unloading the truck
        complex.unloadTruck(mytruck); // or mytruck.unload();
        System.out.println("---------------------------------------------------------------------");

        // Printing out truck now
        System.out.println();
        System.out.println(mytruck);

    }    
}
