package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() throws PokedexException {
        // Création du mock de l'interface
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        // Simuler une réponse quand getPokemonMetadata est appelée
        PokemonMetadata bulbasaurMetadata = new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
        Mockito.when(metadataProvider.getPokemonMetadata(1)).thenReturn(bulbasaurMetadata);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Appeler la méthode sur le mock
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);

        // Vérification des résultats attendus
        assertEquals(1, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());



    }
}
