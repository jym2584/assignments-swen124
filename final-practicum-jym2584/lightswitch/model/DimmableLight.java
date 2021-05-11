package lightswitch.model;
import java.util.*;
/**
 * Part 1
 */
public class DimmableLight implements Light {
    
    public enum LightState {
        ON, DIM, OFF;
    }
    
    private Set<LightObserver> observers;
    private LightState state;
    private int luminosity;

    public DimmableLight() {
        state = LightState.OFF;
        luminosity = 0;
    }

    @Override
    public void flipLights() {

        if(state.equals(LightState.OFF)) { // if it's off, turn it on
            state = LightState.ON;
            luminosity = MAX_LUM;
        
        } else if (state.equals(LightState.ON)) { // if it's on, change it to dim
            state = LightState.DIM;
            luminosity = 50; // 50% luminosity

        } else if (state.equals(LightState.DIM)) { // if it's dim, change it to off
            state = LightState.OFF;
            luminosity = MIN_LUM;
        }

    }

    @Override
    public int getLuminosity() {
        return luminosity;
    }

    @Override
    public String toString() {
        return String.format("DimmableLight{%s, %s}", state, luminosity);
    }

    
    public void register(LightObserver o) {
        observers.add(o);
    }

    public void deregister(LightObserver o) {
        observers.remove(o);
    }

    public static void main(String[] args) {
        DimmableLight light = new DimmableLight();
        System.out.println(light);
        for(int i = 0; i < 3; i++) {
            light.flipLights();
            System.out.println(light + " (GETLUMINOSITY = " + light.getLuminosity() + ")");
        }
    }

}
