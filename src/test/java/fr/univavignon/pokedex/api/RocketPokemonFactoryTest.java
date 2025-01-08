package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() {
        int index = 1; // Bulbasaur
        int cp = 500;
        int hp = 100;
        int dust = 1000;
        int candy = 50;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100); // Vérification de la stat générée
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1.0, pokemon.getIv());
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() {
        int index = -1; // Cas spécial : Ash's Pikachu
        int cp = 500;
        int hp = 100;
        int dust = 1000;
        int candy = 50;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(1000, pokemon.getAttack()); // Vérification des valeurs spéciales
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(0.0, pokemon.getIv());
    }

    @Test
    public void testCreatePokemonWithUnknownIndex() {
        int index = 999; // Indice non défini
        int cp = 400;
        int hp = 80;
        int dust = 800;
        int candy = 30;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals(index, pokemon.getIndex());
        assertEquals("MISSINGNO", pokemon.getName()); // Vérification du comportement par défaut
        assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 100); // Vérification de la stat générée
        assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 100);
        assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 100);
        assertEquals(1.0, pokemon.getIv());
    }
}
