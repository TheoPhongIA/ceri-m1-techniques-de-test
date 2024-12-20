package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() {
        // Initialisation de PokemonMetadataProvider, qui charge les données depuis le fichier "pokemon.txt"
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Test avec un index valide
        int index = 1; // Supposons que l'index 1 correspond à un Pokémon dans le fichier
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(index);

        // Vérification des métadonnées du Pokémon à l'index donné
        Assert.assertNotNull(metadata);
        Assert.assertEquals(index, metadata.getIndex());
        Assert.assertEquals("Pikachu", metadata.getName()); // Nom attendu pour l'index 1
        Assert.assertTrue(metadata.getAttack() > 0); // On vérifie que l'attaque est un nombre positif
        Assert.assertTrue(metadata.getDefense() > 0); // On vérifie que la défense est un nombre positif
        Assert.assertTrue(metadata.getStamina() > 0); // On vérifie que l'endurance est un nombre positif
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Test avec un index invalide (en dehors des index valides)
        int invalidIndex = 9999; // Un index qui n'existe probablement pas dans le fichier
        pokemonMetadataProvider.getPokemonMetadata(invalidIndex); // Cela devrait lancer une PokedexException
    }
}
