package pokemon;

/** Pokemon Class
 * @author Jin Moon
 */
public class Pokemon {  
    private String name;
    private final PokemonType type;
    private int level;

    /**
     * Pokemon method
     * @param name calls for name
     * @param type calls for a type from PokemonType
     * @param level calls an integer level
     */
    public Pokemon (String name, PokemonType type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon (String name, PokemonType type) {
        this(name, type, 1);
    }

    /**
     * Changes name
     * @param name inputs for name
     */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Adds a level to the pokemon if they're less than 100
     */
    public void levelUp() {
        if (level != 100) {
            level += 1;
            System.out.println(name + " leveled up! (Now level " + level + ")" );
        } else {
            System.out.println(name + " cannot evolve anymore.");
        }
    }



    public String getName() { return name; }
    public PokemonType getType() { return type; }
    public int getLevel() { return level; }

    @Override
    public String toString() {
        return "Pokemon{name = <" + name + ">, type = <" + type + ">, level = <" + level + ">}";
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Pokemon)) {
            return false;
        }
    
        Pokemon other = (Pokemon)(o);
        return ( (level == other.level) && type.equals(other.type) );
    }

    public static void main(String[] args) {
        Pokemon myPokemon = new Pokemon("Pikachu", PokemonType.GRASS);
        Pokemon myPokemonz = new Pokemon("Pikachdddu", PokemonType.GRASS);
        Pokemon myPokemonzz = new Pokemon("Pikachddddddddu", PokemonType.FIRE);
        System.out.println(myPokemon);
        System.out.println(myPokemon.equals(myPokemonz));
        System.out.println(myPokemon.equals(myPokemonzz));
    }
}
