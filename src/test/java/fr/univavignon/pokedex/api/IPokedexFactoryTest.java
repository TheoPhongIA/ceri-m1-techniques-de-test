package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory; // Mock de la factory
    private IPokedex pokedex; // Mock du Pokedex

    @Before
    public void setUp() {
        // Création du mock de l'usine de Pokédex
        pokedexFactory = Mockito.mock(IPokedexFactory.class);

        // Définition des mocks pour les dépendances
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        // Création d'une instance simulée de Pokédex
        pokedex = Mockito.mock(IPokedex.class);

        // Simuler la méthode createPokedex pour retourner le mock de pokedex
        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
    }


    // Test de comportement des dépendances
    @Test
    public void testCreatePokedexWithValidDependencies() {
        // Mocks des dépendances
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        // Création d'un mock pour le Pokédex
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        // Appel de la méthode
        IPokedex result = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérification que le résultat est le bon
        assertNotNull(result);
        Mockito.verify(pokedexFactory).createPokedex(metadataProvider, pokemonFactory);
    }

    // Test d'une exception pendant la création (si applicable)
    @Test(expected = IllegalArgumentException.class)
    public void testCreatePokedexThrowsException() {
        // Simuler une exception lors de la création du Pokédex
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        // Simuler que createPokedex lève une exception
        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory))
                .thenThrow(new IllegalArgumentException("Invalid parameters"));

        // Appel qui doit lever l'exception
        pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
    }
}

