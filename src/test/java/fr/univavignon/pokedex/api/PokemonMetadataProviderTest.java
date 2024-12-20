package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() {
        // Initialisation de PokemonMetadataProvider, qui charge les données depuis le fichier "pokemon.txt"
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Test avec un index invalide (en dehors des index valides)
        int invalidIndex = 9999; // Un index qui n'existe probablement pas dans le fichier
        pokemonMetadataProvider.getPokemonMetadata(invalidIndex); // Cela devrait lancer une PokedexException
    }
}
