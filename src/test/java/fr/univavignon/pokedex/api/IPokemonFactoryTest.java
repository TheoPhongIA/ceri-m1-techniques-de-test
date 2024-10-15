package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;  // Ajout d'une instance de IPokedex
    private List<Pokemon> pokemons;

    @Before
    public void setUp() throws PokedexException {
        // Création des mocks pour IPokemonFactory et IPokedex
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        // Spécifiez le chemin vers votre fichier pokemon.txt
        String filePath = "src/ressources/pokemon.txt";

        // Créer une instance de PokemonReader
        PokemonReader reader = new PokemonReader(filePath);

        // Récupérer la liste des Pokémon
        pokemons = reader.getPokemons();

        // Simuler les résultats pour chaque Pokémon dans la liste
        for (Pokemon pokemon : pokemons) {
            Mockito.when(pokedex.getPokemon(pokemon.getIndex())).thenReturn(pokemon);
            Mockito.when(pokemonFactory.createPokemon(
                    pokemon.getIndex(),
                    pokemon.getCp(),
                    pokemon.getAttack(),
                    pokemon.getDefense(),
                    pokemon.getStamina()
            )).thenReturn(pokemon); // Simuler la création du Pokémon
        }
    }

    @Test
    public void testCreateAllPokemons() {
        // Boucle à travers tous les Pokémon
        for (Pokemon originalPokemon : pokemons) {
            // Utiliser les attributs de l'original pour créer le Pokémon
            Pokemon createdPokemon = pokemonFactory.createPokemon(
                    originalPokemon.getIndex(),
                    originalPokemon.getCp(),
                    originalPokemon.getAttack(),
                    originalPokemon.getDefense(),
                    originalPokemon.getStamina()
            );

            // Vérification des attributs
            assertNotNull("Pokemon should not be null", createdPokemon);
            assertEquals("Pokemon name should match", originalPokemon.getName(), createdPokemon.getName());
            assertEquals("CP should match", originalPokemon.getCp(), createdPokemon.getCp());
            assertEquals("Attack should match", originalPokemon.getAttack(), createdPokemon.getAttack());
            assertEquals("Defense should match", originalPokemon.getDefense(), createdPokemon.getDefense());
            assertEquals("Stamina should match", originalPokemon.getStamina(), createdPokemon.getStamina());
        }
    }
}
