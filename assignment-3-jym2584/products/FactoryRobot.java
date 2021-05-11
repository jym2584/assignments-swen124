package products;
import toys.*;
/**
 * Our robot factory that uses the manufacture method from the Factory interface
 * @Author Jin Moon
 */
public class FactoryRobot implements Factory {
    private final String factoryName;
    /**
     * just our constructor
     * @param factoryName takes in a factory name
     */
    public FactoryRobot (String factoryName) {
        this.factoryName = factoryName;
    }

    public FactoryRobot() {
        this("Robot Factory");
    }
    /**
     * manufacturing our product
     * @return returns a new instance of the product
     */
    @Override
    public Product manufacture() {  
        String[] names = {"Robot", "Bender", "Donbot", "Clamps", "Joey Mousepad", "Fanny", "Roberto", "Robot Devil", "Robot Santa", "Calculon", "Hedonismbot", 
                        "Officer URL", "Boxy", "Flexo", "Crushinator", "Gypsy-Bot"};
        
        Product myrobot = new Robot(names[Toy.randomNum(0, names.length-1)], Toy.randomNum(1000000,9999999), Toy.randomNum(29, 99) + .99, true);
        return myrobot;
    }

    @Override
    public String toString() {
        return "A " + factoryName;
    }

    public static void main(String[] args) {
        FactoryRobot myrobotfactory = new FactoryRobot();
        Product myrobot = myrobotfactory.manufacture();
        System.out.println(myrobot);
        (Robot)myrobot.charge();
        

    }
}
