package products;
import java.util.Arrays;
import java.util.Random;
/**
 * Complex class. Array of factories
 * @Author Jin Moon
 */

public class Complex {
    private Factory[] factories;
    private Factory factory;
    private int robotFactoryNum;
    private int dollFactoryNum;

    /**
     * Our complex constructor
     * @param robotFactoryNum calls in the number of robot factories
     * @param dollFactoryNum doll factories
     */
    public Complex(int robotFactoryNum, int dollFactoryNum) {
        this.factories = new Factory[robotFactoryNum + dollFactoryNum];
        this.robotFactoryNum = robotFactoryNum;
        this.dollFactoryNum = dollFactoryNum;
    }

    /**
     * populates the factories array given robotfacotrynum and dollfactorynum
     */
    public void populateComplex() {
        for (int i = 0; i < factories.length; i++) {
            if (i < robotFactoryNum) {
                Factory robotFactory = new FactoryRobot();
                this.factories[i] = robotFactory;
            } else {
                Factory dollFactory = new FactoryDoll();
                this.factories[i] = dollFactory;
            }
        }
        System.out.println("Populated Complex.");
    }

    /**
     * Loads products into the truck given a fandom factory
     * @param truck takes in a truck
     */
    public void loadTruck(Truck truck) {
        for (int i = 0; i < truck.getProducts().length; i++) {
            truck.load( factories[randomNum(0,factories.length-1)].manufacture() );
        }   
    }

    /**
     * Grabs the unload method from Truck.java
     * @param truck takes in a truck to unload
     */
    public void unloadTruck(Truck truck) {
        truck.unload();
    }
    
    /**
     * Random number generator for getting our random factories
     * @param min
     * @param max
     * @return returns the random number
     */
    public static int randomNum(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public Factory[] getFactories() {
        return factories;
    }

    @Override
    public String toString() {
        return "A complex with " + robotFactoryNum + " Robot Factories and " + dollFactoryNum + " Doll Factories" 
                + "\n Factories{" + Arrays.toString(factories) + "}";
    }
    public static void main(String[] args) {
        Complex complex = new Complex(2, 2);
        complex.populateComplex();
        System.out.println(complex);
        Truck mytruck = new Truck(5);

        complex.loadTruck(mytruck);
        System.out.println(mytruck);


    }
}
