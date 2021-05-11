package toys;
import java.util.Random;
import products.*;

/**
 * Our main toy parent
 */
public abstract class Toy extends products.Product{
    /**
     * Toy method
     * @param name a name for the toy
     * @param productCode product number, 7 digits would be nice
     * @param msrp price for the toy
     */
    protected Toy(String name, int productCode, double msrp) {
        super(name, productCode, msrp);
    }


    public abstract void play();



    /**
     * Used to get random sayings or sounds
     * @param min usually from array at 0
     * @param max to array at sayings or sound.length
     * @return returns the random index
     */
    public static int randomNum(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double randomDouble(double min, double max) {
        double r = new Random().nextDouble();
        double randomness = min + (r * (max - min));
        double roundDouble = Math.round(randomness * 100.0) / 100.0;
        return roundDouble;
    }

    public String getName() { return name; }
    public int getProductCode() { return productCode; }
    public double getMsrp() { return msrp; }

    @Override
    public String toString() {
        return "Toy{name= " + name + ", productCode= " + productCode + ", msrp= " + msrp + "}";
    }

    /**
     * Equal if the product codes are the same
     */
    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Toy)) {
            return false;
        }
    
        Toy other = (Toy)(o);
        return (productCode == other.productCode);
    }

}
