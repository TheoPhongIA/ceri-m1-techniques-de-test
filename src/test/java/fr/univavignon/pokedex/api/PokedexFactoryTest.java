package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokedexFactoryTest {

    private PokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Initialisation de PokedexFactory et de ses dépendances
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
    }

    @Test
    public void testCreatePokedex() {
        // Test de la création d'un Pokedex via la factory
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérification que le Pokedex créé n'est pas null
        Assert.assertNotNull(pokedex);

        // Vérification que le Pokedex créé est bien une instance de Pokedex
        Assert.assertTrue(pokedex instanceof Pokedex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePokedexWithInvalidMetadataProvider() {
        // Test de la création d'un Pokedex avec un provider invalide
        IPokemonMetadataProvider invalidProvider = new IPokemonMetadataProvider() {
            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                return null;
            }
        };

        // Le provider n'est pas un PokemonMetadataProvider valide, donc une exception doit être levée
        pokedexFactory.createPokedex(invalidProvider, pokemonFactory);
    }
}
