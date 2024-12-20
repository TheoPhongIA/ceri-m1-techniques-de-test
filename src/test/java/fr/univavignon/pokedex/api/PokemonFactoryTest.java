package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokemonFactoryTest {

    private PokemonFactory pokemonFactory;
    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Initialisation de PokemonFactory et de PokemonMetadataProvider
        pokemonFactory = new PokemonFactory();
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test(expected = RuntimeException.class)
    public void testCreatePokemonWithInvalidIndex() {
        // Test de la création d'un Pokémon avec un index invalide (en dehors de la plage des index valides)
        int invalidIndex = 9999;  // Index qui n'existe probablement pas
        int cp = 1500;
        int hp = 150;
        int dust = 200;
        int candy = 50;

        // Essai de créer un Pokémon avec un index invalide devrait entraîner une exception
        pokemonFactory.createPokemon(invalidIndex, cp, hp, dust, candy);
    }
}
