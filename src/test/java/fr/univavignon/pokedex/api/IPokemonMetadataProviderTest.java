package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PokemonMetadataProvider.
 */
public class IPokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;
    private List<Pokemon> mockPokemons;

    /**
     * Set up the test environment with mock data.
     */
    @Before
    public void setUp() {
        // Create a mock list of Pokemons
        mockPokemons = new ArrayList<>();
        mockPokemons.add(new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 4, 56, 51, 0.8));
        mockPokemons.add(new Pokemon(4, "Charmander", 128, 108, 78, 500, 2, 45, 49, 0.8));
        mockPokemons.add(new Pokemon(7, "Squirtle", 112, 142, 88, 550, 3, 48, 50, 0.8));

        // Create a mock PokemonReader to simulate the loading of Pokémon data
        PokemonReader mockReader = new PokemonReader("mock.txt") {
            @Override
            public List<Pokemon> getPokemons() {
                return mockPokemons;
            }
        };

        // Initialize the provider using the mock data
        metadataProvider = new PokemonMetadataProvider() {
            protected PokemonReader createPokemonReader() {
                return mockReader;
            }
        };
    }

    /**
     * Test getting valid Pokemon metadata by index.
     */
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        assertNotNull("MetadataProvider should not be null", metadataProvider);
        assertNotNull("Metadata list should not be null", metadataProvider.getPokemonsMetadata());
        assertEquals("Metadata list should have 3 entries", 3, metadataProvider.getPokemonsMetadata().size());

        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1); // Index 1
        assertNotNull("Metadata should not be null", metadata);
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    /**
     * Test getting metadata for an invalid index.
     */
    @Test
    public void testGetPokemonMetadataInvalidIndex() {
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(0));
        assertThrows(PokedexException.class, () -> metadataProvider.getPokemonMetadata(100));
    }
}
