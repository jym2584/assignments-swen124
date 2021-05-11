package products;
import java.util.Arrays;
/**
 * Our truck class that loads products onto the truck. Can also unload
 * @Author Jin Moon
 */
public class Truck {
    private int capacity;
    private Product[] products;

    /**
     * takes in an array of products with a specific size
     * @param capacity how many products we can fit onto the cargo
     */
    public Truck(int capacity) {
        this.products = new Product[capacity];
    }
    
    /**
     * loads the truck with a product
     * Puts the product on the back most of the array to the front
     * @param product grabs a product
     */
    public void load(Product product) {
        int i = 0;
        while (i < products.length) {
            int productsIndex = products.length - 1;
            if(products[0] != null) {
                System.out.println("Cannot load any more items onto the truck.");
                break;
            }

            if (products[productsIndex-i] == null) {
                products[productsIndex-i] = product;
                System.out.println("Loaded " + product + " onto slot " + (productsIndex - i));
                break;
            }
            i++;
        }
    }
    /**
     * Unloads the products from the truck starting from the front
     */
    public void unload() {
        int i = 0;
        while (i < products.length) {
            if (i == products.length) {
                break; // Finished unloading all items
            }

            if (products[i] == null) {
                // Skip if there is no product available on the slot
            } else {
                System.out.println("Unloaded " + products[i] + " from slot " + i);
                products[i] = null;
            }
            i++;
        }
    }

    
    public int getCapacity() {
        return capacity;
    }

    public Product[] getProducts() {
        return products;
    }

    public String toString() {
        return "Truck{size = " + products.length + " Products = " + Arrays.toString(products)  + "}";
    }
    public static void main(String[] args) {
        Truck mytruck = new Truck(5);
        FactoryRobot myrobotfactory = new FactoryRobot();
        System.out.println(mytruck);
        mytruck.load(myrobotfactory.manufacture());
        mytruck.load(myrobotfactory.manufacture());
        mytruck.load(myrobotfactory.manufacture());
        mytruck.load(myrobotfactory.manufacture());
        mytruck.load(myrobotfactory.manufacture());
        mytruck.load(myrobotfactory.manufacture());
        mytruck.unload();
        System.out.println(Arrays.toString(mytruck.getProducts()));
        
        

    }

}
