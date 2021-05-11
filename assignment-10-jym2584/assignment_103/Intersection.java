package assignment_103;

import assignment_103.TrafficLight.LightDirection;

public class Intersection {
    public TrafficLight northSouth;
    public TrafficLight eastWest;

    /**
     * Intersection constructor
     * @param vehicle vehicle passing through intersection
     * @param northSouth light
     * @param eastWest light
     */
    public Intersection(TrafficLight northSouth, TrafficLight eastWest) {
        this.northSouth = northSouth;
        this.eastWest = eastWest;
    }

    /**
     * If the current traffic light is green
     * @param light current light
     * @return true if green
     */
    private boolean lightIsGreen(TrafficLight light) {
        return light.getColor().equals(TrafficLight.Color.GREEN);
    }

    /**
     * Gets the traffic light from direction
     * @param vehicle using vehicle to get its direction
     * @return returns one of the two passed in lights
     */
    private TrafficLight getLightFromDirection(Vehicle vehicle) {
        if(vehicle.getDirection().equals(Vehicle.Direction.NORTH) || vehicle.getDirection().equals(Vehicle.Direction.SOUTH)) {
            return northSouth;
        } else {
            return eastWest;
        }
    }

    /**
     * Checks if the vehicle is in the same direction as the light intersection
     * @param vehicle getting vehicle direction
     * @param light getting light direction
     * @return true if vehicle is in the same direction as the light direction (NORTH or SOUTH == NORTH_SOUTH, etc.)
     */
    private boolean vehicleSameDirectionAsLight(Vehicle vehicle, TrafficLight light) {
        if((vehicle.getDirection().equals(Vehicle.Direction.NORTH) || vehicle.getDirection().equals(Vehicle.Direction.SOUTH)) && light.getDirection().equals(LightDirection.NORTH_SOUTH)) {
            return true;
        } else if ((vehicle.getDirection().equals(Vehicle.Direction.EAST) || vehicle.getDirection().equals(Vehicle.Direction.WEST)) && light.getDirection().equals(LightDirection.EAST_WEST)) {
            return true;
        }
        return false;
    }

    /**
     * vehicle driving through Intersection
     * @param vehicle
     */
    public void driveThrough(Vehicle vehicle) {
        TrafficLight lightDirection = getLightFromDirection(vehicle); // gets the traffic light based on the direction the vehicle is in

        synchronized(lightDirection) {
            if ( lightIsGreen(lightDirection) && vehicleSameDirectionAsLight(vehicle, lightDirection)) {
                System.out.println(String.format("%s passes through the %s.", vehicle, lightDirection));
                vehicle.vehiclePassedThrough();
                lightDirection.notifyAll();
            } else {
                while(!lightDirection.getColor().equals(TrafficLight.Color.GREEN)) {
                    try {
                        System.out.println(String.format("%s waits at the %s", vehicle, lightDirection));
                        lightDirection.wait();
                    } catch (InterruptedException e) {
                        // empty
                    }
                }
            }
        }
    }

    public TrafficLight getNorthSouth() {
        return northSouth;
    }

    public TrafficLight getEastWest() {
        return eastWest;
    }

}
