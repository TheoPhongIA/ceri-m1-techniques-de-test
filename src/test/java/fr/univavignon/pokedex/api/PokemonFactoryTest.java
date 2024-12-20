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

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Test de la création d'un Pokémon avec un index valide
        int index = 1;  // Supposons que l'index 1 existe dans le provider
        int cp = 1500;   // Combat Points
        int hp = 150;    // HP
        int dust = 200;  // Poussière nécessaire pour l'amélioration
        int candy = 50;  // Bonbons nécessaires pour l'amélioration

        // Création du Pokémon
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        // Vérification des attributs du Pokémon créé
        Assert.assertNotNull(pokemon);
        Assert.assertEquals(index, pokemon.getIndex());
        Assert.assertEquals("Pikachu", pokemon.getName());  // Assurez-vous que le nom correspond aux métadonnées pour l'index 1
        Assert.assertEquals(cp, pokemon.getCp());
        Assert.assertEquals(hp, pokemon.getHp());
        Assert.assertEquals(dust, pokemon.getDust());
        Assert.assertEquals(candy, pokemon.getCandy());
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
