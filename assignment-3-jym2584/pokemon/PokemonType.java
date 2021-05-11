/**
 * An enumeration class that assigns variables for pokemon type
 * 
 * @author Jin Moon
 */

package pokemon;

public enum PokemonType {
    GRASS("Grass"),
    WATER("Water"),
    FIRE("Fire");

    private String status;

    private PokemonType (String theStatus) {
        this.status = theStatus;
    }
    
    @Override
    public String toString() {
        return status;
    }

}
