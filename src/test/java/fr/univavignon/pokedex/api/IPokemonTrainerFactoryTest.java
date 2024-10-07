package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        // Création du mock pour le PokemonTrainerFactory
        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

        // Mock des dépendances nécessaires
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        // Simuler la création du Pokédex via le mock de PokedexFactory
        Mockito.when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);

        // Simuler la création d'un trainer
        PokemonTrainer ash = new PokemonTrainer("Ash", Team.VALOR, pokedex);
        Mockito.when(trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(ash);
    }


    @Test
    public void testCreateTrainer() {
        // Création d'un dresseur via la factory mockée
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        // Vérifications
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    public void testCreateTrainerWithNullName() {
        // Simuler une création avec un nom nul, cela peut générer une exception dans certains cas
        Mockito.when(trainerFactory.createTrainer(null, Team.MYSTIC, pokedexFactory))
                .thenThrow(new IllegalArgumentException("Trainer name cannot be null"));

        // Vérification que l'exception est bien lancée pour un nom nul
        try {
            trainerFactory.createTrainer(null, Team.MYSTIC, pokedexFactory);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Trainer name cannot be null", e.getMessage());
        }
    }

    @Test
    public void testCreateTrainerWithNullPokedexFactory() {
        // Simuler un comportement où le pokedexFactory est nul
        Mockito.when(trainerFactory.createTrainer("Ash", Team.VALOR, null))
                .thenThrow(new IllegalArgumentException("PokedexFactory cannot be null"));

        // Vérification que l'exception est bien lancée pour un pokedexFactory nul
        try {
            trainerFactory.createTrainer("Ash", Team.VALOR, null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("PokedexFactory cannot be null", e.getMessage());
        }
    }
}
