package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class IPokemonMetadataProviderTest {

    private PokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Initialisation de PokemonFactory
        pokemonFactory = new PokemonFactory();

        // Implémentation anonyme de IPokemonMetadataProvider
        metadataProvider = new IPokemonMetadataProvider() {
            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                // Retourner des métadonnées fictives pour l'index donné
                if (index == 1) {
                    return new PokemonMetadata(1, "Pikachu", 55, 40, 35);
                }
                throw new PokedexException("Invalid index");
            }

            @Override
            public Collection<Object> getPokemonsMetadata() {
                // Retourner une collection de métadonnées fictives
                return Collections.singletonList(new PokemonMetadata(1, "Pikachu", 55, 40, 35));
            }
        };
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
