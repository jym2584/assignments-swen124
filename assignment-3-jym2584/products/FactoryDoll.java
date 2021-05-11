package products;
import toys.*;

/**
 * Our doll factory that uses the manufacture method from the Factory interface
 * @Author Jin Moon
 */
public class FactoryDoll implements Factory {
    private final String factoryName;

    /**
     * just our constructor
     * @param factoryName takes in a factory name
     */
    public FactoryDoll (String factoryName) {
        this.factoryName = factoryName;
    }
    /**
     * makes it named doll factory instead
     */
    public FactoryDoll() {
        this("Doll Factory");
    }
    /**
     * manufacturing our product
     * @return returns a new instance of the product
     */
    @Override
    public Product manufacture() {  
        String[] colors = {"Red", "Blue", "Green", "Teal", "Orange", "Black", "Brown", "Yellow", "Grey", "Turqiouse", "Violet", "Lime Green"};
        String[] names = {"Phillip J. Fry", "Turanga Leela", "Amy Wong", "Hermes Conrad", "Professor Farnsworth", "Dr. Zoidberg", "Zapp Brannigan", "Kif Kroker",
                        "Nibbler", "Morbo", "Linda van Schoonhoven", "Scruffy", "Cubert Farnsworth", "Dwight Conrad","LaBarbara Conrad", "Walt", "Larry", "Igner"};
        
        Product mydoll = new Doll(names[Toy.randomNum(0, names.length-1)], Toy.randomNum(1000000,9999999), Toy.randomNum(4,34) + .99, colors[Toy.randomNum(0,colors.length-1)], colors[Toy.randomNum(0,colors.length-1)]);
        return mydoll;
    }

    @Override
    public String toString() {
        return "A " + factoryName;
    }

}
