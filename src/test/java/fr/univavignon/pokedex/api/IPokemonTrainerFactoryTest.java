package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;

    @Before
    public void setUp() {
        // Création du mock
        trainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

        // Simuler un comportement

    }

    @Test
    public void testCreateTrainer() {

    }
}
