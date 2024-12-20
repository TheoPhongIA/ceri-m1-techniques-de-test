package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonComparatorsTest {

    private Pokemon bulbasaur;
    private Pokemon pikachu;
    private Pokemon charmander;

    @Before
    public void setUp() {
        // Initialisation des Pokémons pour les tests
        bulbasaur = new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 50, 100, 50, 0.85);
        pikachu = new Pokemon(25, "Pikachu", 55, 40, 35, 500, 35, 50, 100, 0.9);
        charmander = new Pokemon(4, "Charmander", 52, 43, 39, 400, 39, 80, 75, 0.8);
    }

    @Test
    public void testCompareByName() {
        // Test du comparateur NAME
        assertTrue(PokemonComparators.NAME.compare(bulbasaur, pikachu) < 0); // Bulbasaur < Pikachu
        assertTrue(PokemonComparators.NAME.compare(pikachu, charmander) > 0); // Pikachu > Charmander
        assertTrue(PokemonComparators.NAME.compare(bulbasaur, charmander) < 0); // Bulbasaur < Charmander
    }

    @Test
    public void testCompareByIndex() {
        // Test du comparateur INDEX
        assertTrue(PokemonComparators.INDEX.compare(bulbasaur, pikachu) < 0); // Index 1 < Index 25
        assertTrue(PokemonComparators.INDEX.compare(pikachu, charmander) > 0); // Index 25 > Index 4
        assertTrue(PokemonComparators.INDEX.compare(bulbasaur, charmander) < 0); // Index 1 < Index 4
    }

    @Test
    public void testCompareByCp() {
        // Test du comparateur CP (Combat Points)
        assertTrue(PokemonComparators.CP.compare(bulbasaur, pikachu) < 0); // CP 300 < CP 500
        assertTrue(PokemonComparators.CP.compare(pikachu, charmander) > 0); // CP 500 > CP 400
        assertTrue(PokemonComparators.CP.compare(bulbasaur, charmander) < 0); // CP 300 < CP 400
    }

    @Test
    public void testCompareEquality() {
        // Test si les comparateurs traitent bien l'égalité
        Pokemon anotherBulbasaur = new Pokemon(1, "Bulbasaur", 49, 49, 45, 300, 50, 100, 50, 0.85);

        assertEquals(0, PokemonComparators.NAME.compare(bulbasaur, anotherBulbasaur)); // Même nom
        assertEquals(0, PokemonComparators.INDEX.compare(bulbasaur, anotherBulbasaur)); // Même index
        assertEquals(0, PokemonComparators.CP.compare(bulbasaur, anotherBulbasaur)); // Même CP
    }
}
