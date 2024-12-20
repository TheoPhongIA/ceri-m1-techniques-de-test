package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class PokedexTest {

    private Pokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @Before
    public void setUp() {
        // Initialisation d'un Pokedex et de quelques Pokémon pour les tests
        pokedex = new Pokedex();

        pokemon1 = new Pokemon(
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

        pokemon2 = new Pokemon(
                2,               // index
                "Bulbasaur",     // nom
                49,              // attaque
                49,              // défense
                45,              // stamina
                800,             // CP
                80,              // HP
                150,             // Dust
                40,              // Candy
                0.8              // IV
        );
    }

    @Test
    public void testAddPokemon() {
        // Test de l'ajout d'un Pokémon dans le Pokedex
        int id1 = pokedex.addPokemon(pokemon1);
        Assert.assertEquals(0, id1); // Le premier Pokémon ajouté aura l'ID 0

        int id2 = pokedex.addPokemon(pokemon2);
        Assert.assertEquals(1, id2); // Le deuxième Pokémon ajouté aura l'ID 1
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Test de la récupération d'un Pokémon par son ID
        int id = pokedex.addPokemon(pokemon1);
        Pokemon retrievedPokemon = pokedex.getPokemon(id);

        Assert.assertEquals(pokemon1.getName(), retrievedPokemon.getName());
        Assert.assertEquals(pokemon1.getCp(), retrievedPokemon.getCp());
        Assert.assertEquals(pokemon1.getHp(), retrievedPokemon.getHp());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidId() throws PokedexException {
        // Test d'une récupération avec un ID invalide
        pokedex.getPokemon(999);  // L'ID 999 n'existe pas
    }

    @Test
    public void testSize() {
        // Test de la taille du Pokedex après ajout de Pokémon
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        Assert.assertEquals(2, pokedex.size()); // Le Pokedex doit contenir 2 Pokémon
    }

    @Test
    public void testGetPokemons() {
        // Test de la récupération de tous les Pokémon dans le Pokedex
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> allPokemons = pokedex.getPokemons();
        Assert.assertEquals(2, allPokemons.size()); // Le Pokedex doit contenir 2 Pokémon
        Assert.assertTrue(allPokemons.contains(pokemon1));
        Assert.assertTrue(allPokemons.contains(pokemon2));
    }

    @Test
    public void testGetPokemonsSortedByCp() {
        // Test de la récupération des Pokémon triés par CP
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2) {
                return Integer.compare(p2.getCp(), p1.getCp()); // Tri décroissant par CP
            }
        });

        Assert.assertEquals(pokemon1, sortedPokemons.get(0)); // Pokémon avec le plus haut CP en premier
        Assert.assertEquals(pokemon2, sortedPokemons.get(1)); // Pokémon avec le CP inférieur en second
    }
}
