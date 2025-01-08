package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RocketPokemonFactoryTest {

    private RocketPokemonFactory factory = new RocketPokemonFactory();

    // Test pour créer un Pokémon avec un index valide
    @Test
    public void testCreatePokemon_ValidIndex() {
        // Index valide
        int index = 1; // Bulbasaur
        int cp = 1000;
        int hp = 100;
        int dust = 500;
        int candy = 50;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(1, pokemon.getIv());
        assertTrue(pokemon.getAttack() >= 0);  // La valeur d'attaque ne doit pas être négative
        assertTrue(pokemon.getDefense() >= 0); // La valeur de défense ne doit pas être négative
        assertTrue(pokemon.getStamina() >= 0); // La valeur de stamina ne doit pas être négative
    }

    // Test pour créer un Pokémon avec un index invalide
    @Test
    public void testCreatePokemon_InvalidIndex() {
        int index = 999; // Un index invalide
        int cp = 1000;
        int hp = 100;
        int dust = 500;
        int candy = 50;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals("MISSINGNO", pokemon.getName()); // Le nom doit être "MISSINGNO" pour un index invalide
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(1, pokemon.getIv());
    }

    // Test pour créer un Pokémon avec un index négatif
    @Test
    public void testCreatePokemon_NegativeIndex() {
        int index = -1; // Index négatif (Ash's Pikachu)
        int cp = 1000;
        int hp = 100;
        int dust = 500;
        int candy = 50;

        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(pokemon);
        assertEquals("Ash's Pikachu", pokemon.getName());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(0, pokemon.getIv()); // IV doit être 0 pour un index négatif
        assertEquals(1000, pokemon.getAttack()); // Les statistiques doivent être à 1000
        assertEquals(1000, pokemon.getDefense());
        assertEquals(1000, pokemon.getStamina());
    }

    // Test pour générer des statistiques de Pokémon
    @Test
    public void testGenerateRandomStat() {
        int totalStats = 0;
        int iterations = 100; // Testons 100 itérations pour vérifier la variance

        for (int i = 0; i < iterations; i++) {
            totalStats += RocketPokemonFactory.generateRandomStat();
        }

        int averageStat = totalStats / iterations;
        assertTrue(averageStat >= 0 && averageStat <= 1000, "La stat générée doit être comprise entre 0 et 1000");
    }

    // Test pour vérifier le comportement d'un Pokémon avec des statistiques aléatoires
    @Test
    public void testRandomStatGeneration() {
        int index = 1; // Un index valide
        int cp = 1000;
        int hp = 100;
        int dust = 500;
        int candy = 50;

        Pokemon pokemon1 = factory.createPokemon(index, cp, hp, dust, candy);
        Pokemon pokemon2 = factory.createPokemon(index, cp, hp, dust, candy);

        assertNotEquals(pokemon1.getAttack(), pokemon2.getAttack(), "Les attaques des Pokémon doivent être différentes à cause de la génération aléatoire");
        assertNotEquals(pokemon1.getDefense(), pokemon2.getDefense(), "Les défenses des Pokémon doivent être différentes à cause de la génération aléatoire");
        assertNotEquals(pokemon1.getStamina(), pokemon2.getStamina(), "Les stataminas des Pokémon doivent être différentes à cause de la génération aléatoire");
    }
}
