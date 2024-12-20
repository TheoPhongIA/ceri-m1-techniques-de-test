package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokemonTest {

    private Pokemon pokemon;

    @Before
    public void setUp() {
        // Initialisation d'un Pokémon pour les tests
        pokemon = new Pokemon(
                1,               // index
                "Pikachu",       // nom
                55,              // attaque
                40,              // défense
                35,              // stamina
                1000,            // CP
                100,             // HP
                200,             // Dust
                50,              // Candy
                0.9              // IV
        );
    }

    @Test
    public void testPokemonAttributes() {
        // Test des attributs du Pokémon
        Assert.assertEquals("Pikachu", pokemon.getName());
        Assert.assertEquals(55, pokemon.getAttack());
        Assert.assertEquals(40, pokemon.getDefense());
        Assert.assertEquals(35, pokemon.getStamina());
        Assert.assertEquals(1000, pokemon.getCp());
        Assert.assertEquals(100, pokemon.getHp());
        Assert.assertEquals(200, pokemon.getDust());
        Assert.assertEquals(50, pokemon.getCandy());
        Assert.assertEquals(0.9, pokemon.getIv(), 0.01); // tolérance de 0.01 pour le double
    }

    @Test
    public void testToString() {
        // Test de la méthode toString
        String expectedString = "Pokemon{cp=1000, hp=100, dust=200, candy=50, iv=0.9}";
        Assert.assertEquals(expectedString, pokemon.toString());
    }

    @Test
    public void testPokedexIntegration() throws PokedexException {
        // Création d'un Pokedex et ajout d'un Pokémon
        Pokedex pokedex = new Pokedex();
        int id = pokedex.addPokemon(pokemon);

        // Test de la récupération du Pokémon via son ID
        Pokemon retrievedPokemon = pokedex.getPokemon(id);
        Assert.assertEquals(pokemon.getName(), retrievedPokemon.getName());
        Assert.assertEquals(pokemon.getCp(), retrievedPokemon.getCp());
        Assert.assertEquals(pokemon.getHp(), retrievedPokemon.getHp());
    }

    @Test(expected = PokedexException.class)
    public void testInvalidPokemonId() throws PokedexException {
        // Essayer de récupérer un Pokémon avec un ID invalide (en dehors des limites)
        Pokedex pokedex = new Pokedex();
        pokedex.getPokemon(999);  // ID invalide
    }
}
