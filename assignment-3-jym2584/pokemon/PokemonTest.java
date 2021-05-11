package pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

/**
 * Testing for Pokemon
 */
@Testable
public class PokemonTest {
    @Test
    public void pokemonEqualityTest(){
        Pokemon mypokemon = new Pokemon("Pokemon", PokemonType.GRASS, 10);
        Pokemon mypokemon2 = new Pokemon("Pokemon", PokemonType.GRASS, 10);
        Pokemon mypokemon3 = new Pokemon("Pokemon", PokemonType.FIRE, 10);

        assertEquals(mypokemon, mypokemon2);
        assertNotEquals(mypokemon, mypokemon3);
        assertEquals("Pokemon{name = <Pokemon>, type = <Grass>, level = <10>}", mypokemon.toString());
    }

    @Test
    public void pokemonChangeName(){
        Pokemon mypokemon = new Pokemon("Pokemon", PokemonType.GRASS, 10);
        String expected = "ThePokemon";

        mypokemon.changeName(expected);
        
        assertEquals(expected, mypokemon.getName());
    }

    @Test
    public void pokemonLevelUp(){
        Pokemon mypokemon = new Pokemon("Pokemon", PokemonType.GRASS, 10);
        int expected = 11;

        mypokemon.levelUp();

        assertEquals(expected, mypokemon.getLevel());
    }

    @Test
    public void pokemonLevelUpEdge(){
        Pokemon mypokemon = new Pokemon("Pokemon", PokemonType.GRASS, 99);
        int expected = 100;
        Pokemon mypokemon2 = new Pokemon("Pokemon", PokemonType.GRASS, 100);

        mypokemon.levelUp();
        mypokemon2.levelUp();

        assertEquals(expected, mypokemon.getLevel());
        assertEquals(expected, mypokemon.getLevel());
    }

}
