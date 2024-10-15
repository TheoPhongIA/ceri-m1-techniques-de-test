package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private List<Pokemon> pokemons;

    @Before
    public void setUp() throws PokedexException {
        // Spécifiez le chemin vers votre fichier pokemon.txt
        String filePath = "src/ressources/pokemon.txt";

        // Créer une instance de PokemonReader
        PokemonReader reader = new PokemonReader(filePath);

        // Récupérer la liste des Pokémon
        pokemons = reader.getPokemons();

        // Création du mock
        pokedex = Mockito.mock(IPokedex.class);

        // Simuler les résultats pour chaque Pokémon dans la liste
        for (Pokemon pokemon : pokemons) {
            Mockito.when(pokedex.getPokemon(pokemon.getIndex())).thenReturn(pokemon);
        }

        // Simuler la taille du Pokedex
        Mockito.when(pokedex.size()).thenReturn(pokemons.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        // Vérifier que le Pokedex retourne le bon Pokémon pour chaque index
        for (Pokemon pokemon : pokemons) {
            Pokemon fetchedPokemon = pokedex.getPokemon(pokemon.getIndex());
            assertEquals(pokemon.getName(), fetchedPokemon.getName());
        }
    }



    @Test
    public void testSize() {
        // Vérifier que la taille du Pokedex correspond à la taille de la liste
        assertEquals(pokemons.size(), pokedex.size());
    }



    @Test
    public void testGetPokemonWithNegativeId() throws PokedexException {
        int negativeId = -1; // Un ID négatif
        Pokemon pokemon = pokedex.getPokemon(negativeId);
        assertNull("Expected null for negative Pokemon ID", pokemon);
    }



    @Test
    public void testGetPokemonWithOutOfBoundId() throws PokedexException {
        int outOfBoundId = 999; // Un ID au-dessus de la taille maximale
        Pokemon pokemon = pokedex.getPokemon(outOfBoundId);
        assertNull("Expected null for out of bound Pokemon ID", pokemon);
    }



    @Test
    public void testEmptyPokedex() throws PokedexException {
        IPokedex emptyPokedex = Mockito.mock(IPokedex.class);
        Mockito.when(emptyPokedex.size()).thenReturn(0);
        assertEquals(0, emptyPokedex.size());
    }
}


