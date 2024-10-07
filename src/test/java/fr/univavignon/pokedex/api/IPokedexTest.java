package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class IPokedexTest {

    private IPokedex pokedex;

    @Before
    public void setUp() throws PokedexException {
        // Création du mock
        pokedex = Mockito.mock(IPokedex.class);

        // Simuler des résultats
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", 613, 64, 4000, 4, 126, 126, 90, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        Mockito.when(pokedex.getPokemon(1)).thenReturn(bulbasaur);
        Mockito.when(pokedex.size()).thenReturn(1);

        //Mockito.when(pokedex.getPokemon(151)).thenThrow(new PokedexException("Invalid Pokémon index"));
        //Mockito.when(pokedex.getPokemon(999)).thenThrow(new PokedexException("Pokémon not found with ID 999"));
        //Mockito.when(pokedex.getPokemon(-1)).thenThrow(new PokedexException("ID must be between 0 and 150"));
        Mockito.when(pokedex.getPokemon(Mockito.anyInt())).thenAnswer(invocation -> {
            int id = invocation.getArgument(0);
            // Vérification si l'ID est dans la plage 0-150 inclus
            if (id < 0 || id > 150) {
                throw new PokedexException("ID must be between 0 and 150");
            }
            return bulbasaur; // Retourner bulbasaur pour les ID valides
        });
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(1);
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test
    public void testSize() {
        assertEquals(1, pokedex.size());
    }
}

