package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Initialiser le metadataProvider avant chaque test
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Test avec un index valide
        int validIndex = 1; // Assurez-vous que l'index 1 est valide dans votre test
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(validIndex);

        // Assurez-vous que les métadonnées retournées sont non nulles et valides
        assertNotNull("PokemonMetadata should not be null", metadata);
        assertEquals("Index should match", validIndex, metadata.getIndex());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Test avec un index invalide
        int invalidIndex = -1; // Un index invalide qui devrait générer une exception
        metadataProvider.getPokemonMetadata(invalidIndex);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataOutOfRangeIndex() throws PokedexException {
        // Test avec un index hors de la plage des indices valides
        int outOfRangeIndex = 9999; // Choisir un index supposé être hors de la plage valide
        metadataProvider.getPokemonMetadata(outOfRangeIndex);
    }
}
