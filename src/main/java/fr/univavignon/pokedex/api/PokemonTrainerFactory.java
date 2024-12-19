package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Creates a new Pokémon Trainer instance with the given name, team, and Pokedex factory.
     *
     * @param name the name of the trainer.
     * @param team the team of the trainer.
     * @param pokedexFactory the factory used to create the associated Pokedex instance.
     * @return the newly created Pokémon Trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Création de PokemonMetadataProvider avec des valeurs spécifiques pour name et type
        // Vous pouvez modifier ces valeurs selon les besoins
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

        // Création du Pokedex en utilisant la factory et l'instance de PokemonMetadataProvider
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, new PokemonFactory());

        // Création du PokemonTrainer avec les informations du trainer et du pokedex
        return new PokemonTrainer(name, team, pokedex);
    }
}
