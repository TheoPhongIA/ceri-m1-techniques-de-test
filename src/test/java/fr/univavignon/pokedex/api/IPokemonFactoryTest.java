package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Création du mock
        pokemonFactory = Mockito.mock(IPokemonFactory.class);

        // Définition d'un comportement simulé
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", 126, 126, 4000, 613, 64, 4000, 4, 56);
        Mockito.when(pokemonFactory.createPokemon(1, 613, 64, 4000, 4)).thenReturn(bulbasaur);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(613, pokemon.getCp());
    }
}
