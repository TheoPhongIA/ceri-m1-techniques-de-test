package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final String name;
    private final String type;

    // Constructeur pour initialiser le nom et le type
    public PokemonMetadataProvider(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PokemonMetadata{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Retourner les métadonnées du Pokémon en fonction de l'index (à définir)
        return null;
    }
}

