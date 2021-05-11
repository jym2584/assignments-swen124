package assignment_103;
/**
 * Traffic Light thread
 */
public class TrafficLight extends Thread {
    /**
     * Color enum
     */
    public enum Color {
        RED, GREEN, YELLOW;
    }

    /**
     * Light's direction enumeration
     */
    public enum LightDirection {
        NORTH_SOUTH("North/South"), 
        EAST_WEST("East/West");

        private String direction;

        private LightDirection (String direction) {
            this.direction = direction;
        }

        @Override
        public String toString() {
            return direction;
        }
    }

    /**
     * Direction of the light
     */
    private final LightDirection direction;
    /**
     * Current color of the light
     */
    private Color color;
    /**
     * shared lock amongst the lights
     */
    private final Object lock;

    /**
     * Traffic Light constructor
     * @param direction direction that the light is facing
     * @param lock shared lock
     */
    public TrafficLight(LightDirection direction, Object lock) {
        this.direction = direction;
        this.color = Color.RED;
        this.lock = lock;
    }

    /**
     * Light changes color based on time
     * If there are more than one light, waits until the other one is red before turning green
     */
    @Override
    public void run() {
        System.out.println(String.format("%s started as red.", this));
        synchronized(lock) {
            while(true) {
                try {
                    Thread.sleep(Main.SECONDS);
                    color = Color.GREEN;
                    System.out.println(String.format("%s turned %s.", this, color));

                    Thread.sleep(Main.SECONDS * 5);
                    color = Color.YELLOW;
                    System.out.println(String.format("%s turned %s.", this, color));

                    Thread.sleep(Main.SECONDS * 2);
                    color = Color.RED;
                    System.out.println(String.format("%s turned %s.", this, color));

                    lock.notify(); // notify the other signal that is waiting for the current light to turn red
                    lock.wait(); // wait since the current light is red now
                } catch (InterruptedException ie) {}
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s light", direction);
    }
    
    /**
     * Gets the traffic light's signal color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the direction the light is facing
     * @return
     */
    public LightDirection getDirection() {
        return direction;
    }

    /**
     * Gets the lock
     * @return
     */
    public Object getLock() {
        return lock;
    }



    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        TrafficLight lightOne = new TrafficLight(LightDirection.NORTH_SOUTH, lock);
        TrafficLight lightTwo = new TrafficLight(LightDirection.EAST_WEST, lock);
        lightOne.start();
        lightTwo.start();
    }
}
