package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Initialisation de la classe réelle (pas de mock ici)
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Vérifie que les métadonnées pour l'index 1 (Bulbasaur) sont correctes
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);

        assertNotNull(metadata);
        assertEquals(1, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithInvalidId() throws PokedexException {
        // Teste un index invalide inférieur à 1
        metadataProvider.getPokemonMetadata(0);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataWithOutOfBoundId() throws PokedexException {
        // Teste un index invalide supérieur à la taille (151+)
        metadataProvider.getPokemonMetadata(200);
    }

    @Test
    public void testGetPokemonMetadataWithBoundaryIndex() throws PokedexException {
        // Teste le premier et le dernier index valides
        PokemonMetadata firstMetadata = metadataProvider.getPokemonMetadata(1);
        PokemonMetadata lastMetadata = metadataProvider.getPokemonMetadata(151);

        assertNotNull(firstMetadata);
        assertEquals(1, firstMetadata.getIndex());
        assertEquals("Bulbasaur", firstMetadata.getName()); // Exemple

        assertNotNull(lastMetadata);
        assertEquals(151, lastMetadata.getIndex());
        assertEquals("Mew", lastMetadata.getName()); // Exemple
    }

    @Test
    public void testPokemonsMetadataSize() {
        assertNotNull(metadataProvider);
        assertEquals(151, metadataProvider.pokemonsMetadata.size());
    }


}
