package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    /**
     * Creates a new Pokémon instance by computing its IVs.
     *
     * @param index the Pokémon's index.
     * @param cp the Pokémon's Combat Power.
     * @param hp the Pokémon's Health Points.
     * @param dust the required Stardust for upgrading the Pokémon.
     * @param candy the required Candy for upgrading the Pokémon.
     * @return the newly created Pokémon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // Calculate IVs (Individual Values) - Here we simulate random IVs as an example.
        int ivAttack = (int) (Math.random() * 15); // IVs are typically between 0 and 15.
        int ivDefense = (int) (Math.random() * 15);
        int ivStamina = (int) (Math.random() * 15);

        // Create the Pokemon with the given parameters.
        return new Pokemon(index, cp, hp, dust, candy, ivAttack, ivDefense, ivStamina);
    }
}
