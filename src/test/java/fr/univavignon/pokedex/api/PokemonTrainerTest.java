package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokemonTrainerTest {

    private PokemonTrainer pokemonTrainer;
    private IPokedex pokedex;
    private Team team;

    @Before
    public void setUp() {
        // Création d'une équipe fictive pour le Pokémon Trainer
        team = Team.MYSTIC; // Exemple de l'équipe "Mystic"

        // Création d'un Pokedex vide pour le test
        pokedex = new Pokedex();

        // Initialisation de PokemonTrainer avec un nom, une équipe et un Pokedex
        pokemonTrainer = new PokemonTrainer("Ash Ketchum", team, pokedex);
    }

    @Test
    public void testGetName() {
        // Test que le nom du Pokémon Trainer est correctement initialisé
        Assert.assertEquals("Ash Ketchum", pokemonTrainer.getName());
    }

    @Test
    public void testGetTeam() {
        // Test que l'équipe du Pokémon Trainer est correctement initialisée
        Assert.assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        // Test que le Pokedex du Pokémon Trainer est correctement initialisé
        Assert.assertNotNull(pokemonTrainer.getPokedex());
        Assert.assertEquals(pokedex, pokemonTrainer.getPokedex());
    }

    @Test
    public void testAddPokemonToPokedex() throws PokedexException {
        // Test l'ajout d'un Pokémon au Pokedex du trainer
        Pokemon pokemon = new Pokemon(1, "Pikachu", 55, 40, 35, 112, 100, 200, 50, 0.9);
        int index = pokemonTrainer.getPokedex().addPokemon(pokemon);

        // Vérifier que le Pokémon a été ajouté à l'index 0
        Assert.assertEquals(0, index);
        Assert.assertEquals(pokemon, pokemonTrainer.getPokedex().getPokemon(index));
    }
}
