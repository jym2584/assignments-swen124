package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonComparator implements Comparator<Pokemon>{

    @Override
    public int compare(Pokemon o1, Pokemon o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
    public static void main(String[] args) {
        List <Pokemon> pokedex = new ArrayList<>();
        pokedex.add(new Pokemon(130, "Gyrados"));
        pokedex.add(new Pokemon(4, "Charmander"));
        pokedex.add(new Pokemon(7, "Squirtle"));
        pokedex.add(new Pokemon(129, "Magikarp"));
        pokedex.add(new Pokemon(26, "Raichu"));
        
        PokemonComparator comp = new PokemonComparator();
        Collections.sort(pokedex, comp);
        System.out.println(pokedex);
    }
}