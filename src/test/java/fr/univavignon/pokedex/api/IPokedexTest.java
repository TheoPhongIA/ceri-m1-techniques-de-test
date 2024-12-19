package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.List;

public class PokedexTest {

    private Pokedex pokedex;

    @Before
    public void setUp() {
        // Initialisation de la Pokedex avant chaque test
        pokedex = new Pokedex();
    }

    @Test
    public void testSize() {
        // Teste la taille de la Pokedex initiale (doit être 0)
        assertEquals(0, pokedex.size());

        // Ajout d'un Pokémon et vérification de la taille
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90);
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        // Teste l'ajout d'un Pokémon
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90);
        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index); // L'index du premier Pokémon ajouté doit être 0
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Teste la récupération d'un Pokémon valide
        Pokemon pokemon = new Pokemon(1, "Bulbasaur", 126, 126, 90);
        pokedex.addPokemon(pokemon);

        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertNotNull(retrievedPokemon);
        assertEquals("Bulbasaur", retrievedPokemon.getName());

        // Teste un index invalide (devrait lancer une exception)
        try {
            pokedex.getPokemon(1);
            fail("Exception PokedexException attendue");
        } catch (PokedexException e) {
            assertEquals("Invalid Pokedex ID: 1", e.getMessage());
        }
    }

    @Test
    public void testGetPokemons() {
        // Teste la méthode qui retourne tous les Pokémon
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90);
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Ivysaur", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSorted() {
        // Teste la méthode qui retourne tous les Pokémon triés
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90);
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", 156, 158, 120);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        // Tri par nom
        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertNotNull(sortedPokemons);
        assertEquals(2, sortedPokemons.size());
        assertEquals("Bulbasaur", sortedPokemons.get(0).getName());
        assertEquals("Ivysaur", sortedPokemons.get(1).getName());
    }

    @Test
    public void testCreatePokemon() {
        // Teste la méthode createPokemon (actuellement non implémentée)
        Pokemon pokemon = pokedex.createPokemon(1, 500, 100, 300, 50);
        assertNull(pokemon);  // Devrait être nul car la méthode n'est pas implémentée
    }

    @Test
    public void testGetPokemonMetadata() {
        // Teste la méthode getPokemonMetadata (actuellement non implémentée)
        try {
            PokemonMetadata metadata = pokedex.getPokemonMetadata(1);
            assertNull(metadata);  // Devrait être nul car la méthode n'est pas implémentée
        } catch (PokedexException e) {
            fail("Exception ne devrait pas être lancée ici.");
        }
    }
}
