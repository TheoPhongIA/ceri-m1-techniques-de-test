package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class PokemonMetadataTest {

    private PokemonMetadata pikachuMetadata;
    private PokemonMetadata bulbasaurMetadata;

    @Before
    public void setUp() {
        // Initialisation de PokemonMetadata avec des valeurs fictives pour plusieurs Pokémon
        pikachuMetadata = new PokemonMetadata(1, "Pikachu", 55, 40, 35);
        bulbasaurMetadata = new PokemonMetadata(2, "Bulbasaur", 49, 49, 45);
    }

    @Test
    public void testGetIndex() {
        // Test que l'index du Pokémon est correctement initialisé
        Assert.assertEquals(1, pikachuMetadata.getIndex());
        Assert.assertEquals(2, bulbasaurMetadata.getIndex());
    }

    @Test
    public void testGetName() {
        // Test que le nom du Pokémon est correctement initialisé
        Assert.assertEquals("Pikachu", pikachuMetadata.getName());
        Assert.assertEquals("Bulbasaur", bulbasaurMetadata.getName());
    }

    @Test
    public void testGetAttack() {
        // Test que l'attaque du Pokémon est correctement initialisée
        Assert.assertEquals(55, pikachuMetadata.getAttack());
        Assert.assertEquals(49, bulbasaurMetadata.getAttack());
    }

    @Test
    public void testGetDefense() {
        // Test que la défense du Pokémon est correctement initialisée
        Assert.assertEquals(40, pikachuMetadata.getDefense());
        Assert.assertEquals(49, bulbasaurMetadata.getDefense());
    }

    @Test
    public void testGetStamina() {
        // Test que l'endurance du Pokémon est correctement initialisée
        Assert.assertEquals(35, pikachuMetadata.getStamina());
        Assert.assertEquals(45, bulbasaurMetadata.getStamina());
    }
}
