package lightswitch.model;
/**
 * Part 1
 */
public interface Light {
    int MIN_LUM = 0;
    int MAX_LUM = 100;

    void flipLights();

    default int getLuminosity() { // We don't want this for basic light
        throw new UnsupportedOperationException();
    }

    void register(LightObserver observer);

    void deregister(LightObserver observer);

}
