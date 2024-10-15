package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;
    private List<Pokemon> pokemons;

    @Before
    public void setUp() throws PokedexException {
        // Création du mock de l'interface
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        // Spécifiez le chemin vers votre fichier pokemon.txt
        String filePath = "src/ressources/pokemon.txt";

        // Créer une instance de PokemonReader
        PokemonReader reader = new PokemonReader(filePath);

        // Récupérer la liste des Pokémon
        pokemons = reader.getPokemons();

        // Simuler une réponse quand getPokemonMetadata est appelée pour chaque Pokémon
        for (Pokemon pokemon : pokemons) {
            PokemonMetadata metadata = new PokemonMetadata(
                    pokemon.getIndex(),
                    pokemon.getName(),
                    pokemon.getAttack(),
                    pokemon.getDefense(),
                    pokemon.getStamina()
            );
            Mockito.when(metadataProvider.getPokemonMetadata(pokemon.getIndex())).thenReturn(metadata);
        }
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Vérifier que la méthode retourne les métadonnées correctes
        PokemonMetadata bulbasaurMetadata = metadataProvider.getPokemonMetadata(1);
        assertNotNull("Metadata for Bulbasaur should not be null", bulbasaurMetadata);
        assertEquals("Bulbizarre", bulbasaurMetadata.getName());
        assertEquals(126, bulbasaurMetadata.getAttack());
        assertEquals(126, bulbasaurMetadata.getDefense());
        assertEquals(90, bulbasaurMetadata.getStamina());
    }


    @Test
    public void testGetPokemonMetadataWithInvalidId() throws PokedexException {
        // Tester un ID qui n'existe pas (par exemple, -1)
        int invalidId = -1; // ID qui n'existe pas
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(invalidId);
        assertNull("Expected null for non-existent Pokemon ID", metadata);
    }


    @Test
    public void testGetPokemonMetadataWithOutOfBoundId() throws PokedexException {
        // Tester un ID qui n'existe pas (par exemple, au-delà de la plage valide)
        int invalidId = 999; // ID qui n'existe pas
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(invalidId);
        assertNull("Expected null for non-existent Pokemon ID", metadata);
    }



}
