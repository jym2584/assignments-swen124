package lightswitch.model;
import java.util.*;
/**
 * Part 1
 */
public class BasicLight implements Light {
    private Set<LightObserver> observers;
    private boolean lightsOn;

    public BasicLight() {
        lightsOn = false;
    }

    @Override
    public void flipLights() {
        if(!lightsOn) {
            lightsOn = true;
        } else {
            lightsOn = false;
        }
    }

    @Override
    public String toString() {
        return String.format("BasicLight{%s}", lightsOn);
    }

    public void register(LightObserver o) {
        observers.add(o);
    }

    public void deregister(LightObserver o) {
        observers.remove(o);
    }

    public static void main(String[] args) {
        BasicLight light = new BasicLight();
        System.out.println(light);
        light.flipLights();
        System.out.println(light);
    }
}
