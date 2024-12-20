package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokemonMetadataTest {

    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() {
        // Initialisation de PokemonMetadata avec des valeurs fictives
        int index = 1;
        String name = "Pikachu";
        int attack = 55;
        int defense = 40;
        int stamina = 35;

        pokemonMetadata = new PokemonMetadata(index, name, attack, defense, stamina);
    }

    @Test
    public void testGetIndex() {
        // Test que l'index du Pokémon est correctement initialisé
        Assert.assertEquals(1, pokemonMetadata.getIndex());
    }

    @Test
    public void testGetName() {
        // Test que le nom du Pokémon est correctement initialisé
        Assert.assertEquals("Pikachu", pokemonMetadata.getName());
    }

    @Test
    public void testGetAttack() {
        // Test que l'attaque du Pokémon est correctement initialisée
        Assert.assertEquals(55, pokemonMetadata.getAttack());
    }

    @Test
    public void testGetDefense() {
        // Test que la défense du Pokémon est correctement initialisée
        Assert.assertEquals(40, pokemonMetadata.getDefense());
    }

    @Test
    public void testGetStamina() {
        // Test que l'endurance du Pokémon est correctement initialisée
        Assert.assertEquals(35, pokemonMetadata.getStamina());
    }
}
