package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sample Pokemon class demonstrating the Comparable interface
 */
public class Pokemon implements Comparable <Pokemon>{
    private int number;
    private String name;

    public Pokemon (int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public int hashCode () {
        int hash = (int)Math.pow (name.hashCode (), number);
        return hash;
    }

    @Override
    public String toString () {
        return number + ": " + name;
    }

    @Override
    public int compareTo (Pokemon other) {
        return number - other.number;
    }

    public String getName () {
        return name;
    }

    public static void main(String[] args) {
        List <Pokemon> pokedex = new ArrayList<>();
        pokedex.add (new Pokemon (130,"gyrados"));
        pokedex.add (new Pokemon (4,"charmander"));
        pokedex.add (new Pokemon (7,"squirtle"));
        pokedex.add (new Pokemon (129,"magicarp"));
        pokedex.add (new Pokemon (26,"raichu"));

        Collections.sort (pokedex);
        System.out.println (pokedex);

    }
}
