package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new instance of IPokedex using the given metadata provider and pokemon factory.
     *
     * @param metadataProvider the metadata provider the created Pokedex will use.
     * @param pokemonFactory the pokemon factory the created Pokedex will use.
     * @return a newly created instance of IPokedex.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // On vérifie si le metadataProvider est bien une instance de PokemonMetadataProvider
        if (metadataProvider instanceof PokemonMetadataProvider) {
            // Ici, nous avons une instance de PokemonMetadataProvider, que nous allons utiliser pour créer un Pokedex
            PokemonMetadataProvider pokemonMetadataProvider = (PokemonMetadataProvider) metadataProvider;

            // Création du Pokedex avec le PokemonMetadataProvider
            return new Pokedex(); // En supposant que Pokedex accepte un PokemonMetadataProvider
        }

        // Si ce n'est pas un PokemonMetadataProvider, on lance une exception
        throw new IllegalArgumentException("Invalid PokemonMetadataProvider provided");
    }
}

