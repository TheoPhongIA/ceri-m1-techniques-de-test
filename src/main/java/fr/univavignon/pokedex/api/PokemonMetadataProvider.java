package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private List<PokemonMetadata> pokemonsMetadata; // Liste des métadonnées de Pokémon

    // Constructeur
    public PokemonMetadataProvider() {
        PokemonReader pokemonReader = new PokemonReader("pokemon.txt");
        List<Pokemon> pokemons = pokemonReader.getPokemons(); // Obtenir la liste des Pokémon
        pokemonsMetadata = new ArrayList<>(); // Initialiser la liste des métadonnées

        // Convertir chaque Pokémon en PokemonMetadata
        for (Pokemon pokemon : pokemons) {
            pokemonsMetadata.add(new PokemonMetadata(
                    pokemon.getIndex(),
                    pokemon.getName(),
                    pokemon.getAttack(),
                    pokemon.getDefense(),
                    pokemon.getStamina()
            ));
        }
    }

    // Implémentation de la méthode de l'interface
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 1 || index > pokemonsMetadata.size()) {
            throw new PokedexException("Invalid index");
        }
        return pokemonsMetadata.get(index - 1);
    }

    @Override
    public Collection<Object> getPokemonsMetadata() {
        return List.of();
    }
}
