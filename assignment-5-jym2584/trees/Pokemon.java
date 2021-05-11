package trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pokemon implements Comparable <Pokemon>{
    private int number;
    private String name;

    public Pokemon(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Pokemon other) {
        return number - other.number;
    }

    public static void main(String[] args) {
        List <Pokemon> pokedex = new ArrayList<>();
        pokedex.add(new Pokemon(130, "Gyrados"));
        pokedex.add(new Pokemon(4, "Charmander"));
        pokedex.add(new Pokemon(7, "Squirtle"));
        pokedex.add(new Pokemon(129, "Magikarp"));
        pokedex.add(new Pokemon(26, "Raichu"));
        
        Collections.sort(pokedex);
        System.out.println(pokedex);
    }
}
