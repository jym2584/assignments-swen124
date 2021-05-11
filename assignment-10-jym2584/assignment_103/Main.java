package assignment_103;
import java.util.*;

import assignment_103.TrafficLight.LightDirection;
import assignment_103.Vehicle.Direction;

public class Main {
    /**
     * Global variable used to change the speed of the traffic light
     */
    public static final int SECONDS = 1000;

    /**
     * Driver code
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // Initialization
        List<Vehicle.Direction> vehicleDirections = Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);

        Object lock = new Object();
        TrafficLight lightOne = new TrafficLight(LightDirection.NORTH_SOUTH, lock);
        TrafficLight lightTwo = new TrafficLight(LightDirection.EAST_WEST, lock);

        Intersection intersection = new Intersection(lightOne, lightTwo);

        Thread.sleep(20);

        // Start 
        lightOne.start();
        lightTwo.start();

        Thread.sleep(20); // just so that the first 2 lights are able to initialize first before the rest of the vehicles
        
        for(int i = 1; i <= 100; i++) {
            Vehicle vehicle = new Vehicle(i, vehicleDirections.get(new Random().nextInt(3)), intersection);
            vehicle.start();
            Thread.sleep(new Random().nextInt(2001));
        }
    }
}
