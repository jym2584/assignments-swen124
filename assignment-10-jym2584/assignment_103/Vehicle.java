package assignment_103;

public class Vehicle extends Thread {
    /**
     * Direction the vehicle is going from
     */
    public enum Direction {
        NORTH, SOUTH, EAST, WEST;
    }

    /**
     * Vehicle id
     */
    private final int id;
    /**
     * Direction the vehicle is going from
     */
    private final Direction direction;
    /**
     * Intersection that the vehicle is passing through
     */
    private final Intersection intersection;

    /**
     * If the vehicle has passed through the intersection
     */
    private boolean passedThrough;

    /**
     * Vehicle constructor
     * @param id Vehicle identifer
     * @param direction Direction the vehicle is going from
     * @param intersection Intersection that the vehicle is passing through
     */
    public Vehicle(int id, Direction direction, Intersection intersection) {
        this.id = id;
        this.direction = direction;
        this.intersection = intersection;
        passedThrough = false;
        
    }

    /**
     * Vehicle driving through intersection
     */
    @Override
    public void run() {
        while(true) {
            if(passedThrough) { // if the vehicle has passed through the intersection
                break; // we can stop the thread
            } else {
                intersection.driveThrough(this); // attempt to pass through the intersection otherwise
            }
        }
    }


    /**
     * Set to true if the vehicle has passed through
     * ONLY BEING USED BY Intersection.java
     */
    public void vehiclePassedThrough() {
        this.passedThrough = true;
    }
    /**
     * Gets the direction of the vehicle
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Gets the intersection of the vehicle
     * @return
     */
    public Intersection getIntersection() {
        return intersection;
    }

    /**
     * Gets the vehicle's identifier number
     * @return
     */
    public int getVehicleId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Vehicle (%d) from the %s direction", id, direction);
    }

}
