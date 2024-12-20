package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PokemonTrainerFactoryTest {

    private PokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        // Création de la factory qui sera utilisée pour créer le Pokedex
        pokedexFactory = Mockito.mock(IPokedexFactory.class);

        // Création de l'instance de PokemonTrainerFactory
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        // Création de l'objet Pokedex mocké
        IPokedex pokedex = Mockito.mock(IPokedex.class);

        // Création du Pokémon Trainer
        String trainerName = "Ash Ketchum";
        Team trainerTeam = Team.MYSTIC;

        // Configurer la factory pour retourner un Pokedex mocké
        Mockito.when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);

        // Création du Pokémon Trainer via la factory
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, pokedexFactory);

        // Vérification des attributs du Pokémon Trainer
        Assert.assertNotNull(trainer);
        Assert.assertEquals(trainerName, trainer.getName());
        Assert.assertEquals(trainerTeam, trainer.getTeam());
        Assert.assertEquals(pokedex, trainer.getPokedex());
    }

    @Test
    public void testCreateTrainerWithNullPokedexFactory() {
        // Création d'un Pokémon Trainer sans PokedexFactory (null)
        String trainerName = "Misty";
        Team trainerTeam = Team.VALOR;

        try {
            // Lancer la méthode createTrainer avec un PokedexFactory null devrait entraîner une exception
            pokemonTrainerFactory.createTrainer(trainerName, trainerTeam, null);
            Assert.fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Vérification que l'exception attendue a bien été lancée
            Assert.assertEquals("PokedexFactory cannot be null", e.getMessage());
        }
    }
}
