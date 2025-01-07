package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PokemonComparators.
 */
public class PokemonComparatorsTest {

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;

    /**
     * Initialize test data.
     */
    @Before
    public void setUp() {
        // Create sample Pokemon instances
        pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 4, 56, 51, 0.8);
        pokemon2 = new Pokemon(4, "Charmander", 128, 108, 78, 500, 2, 45, 49, 0.8);
        pokemon3 = new Pokemon(7, "Squirtle", 112, 142, 88, 550, 3, 48, 50, 0.8);
    }

    /**
     * Test NAME comparator.
     */
    @Test
    public void testNameComparator() {
        int result1 = PokemonComparators.NAME.compare(pokemon1, pokemon2);
        int result2 = PokemonComparators.NAME.compare(pokemon2, pokemon3);

        assertTrue("Bulbasaur should come before Charmander", result1 < 0);
        assertTrue("Charmander should come before Squirtle", result2 < 0);
    }

    /**
     * Test INDEX comparator.
     */
    @Test
    public void testIndexComparator() {
        int result1 = PokemonComparators.INDEX.compare(pokemon1, pokemon2);
        int result2 = PokemonComparators.INDEX.compare(pokemon2, pokemon3);

        assertTrue("Bulbasaur should have a lower index than Charmander", result1 < 0);
        assertTrue("Charmander should have a lower index than Squirtle", result2 < 0);
    }

    /**
     * Test CP comparator.
     */
    @Test
    public void testCpComparator() {
        int result1 = PokemonComparators.CP.compare(pokemon1, pokemon2);
        int result2 = PokemonComparators.CP.compare(pokemon3, pokemon2);

        assertTrue("Bulbasaur should have more CP than Charmander", result1 > 0);
        assertTrue("Squirtle should have more CP than Charmander", result2 > 0);
    }

    /**
     * Test consistency of compare method.
     */
    @Test
    public void testConsistency() {
        assertEquals("Comparing a Pokemon with itself should return 0", 0, PokemonComparators.NAME.compare(pokemon1, pokemon1));
        assertEquals("Comparing a Pokemon with itself should return 0", 0, PokemonComparators.INDEX.compare(pokemon2, pokemon2));
        assertEquals("Comparing a Pokemon with itself should return 0", 0, PokemonComparators.CP.compare(pokemon3, pokemon3));
    }
}
