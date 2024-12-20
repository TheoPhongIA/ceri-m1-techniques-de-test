package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider; // Le mock de l'interface

    @Before
    public void setUp() throws PokedexException {
        // Initialise les mocks
        MockitoAnnotations.initMocks(this);

        // Simuler une réponse quand getPokemonMetadata est appelée
        PokemonMetadata bulbasaurMetadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(bulbasaurMetadata);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Appeler la méthode sur le mock
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);

        // Vérification des résultats attendus
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(90, metadata.getStamina());
    }
}
