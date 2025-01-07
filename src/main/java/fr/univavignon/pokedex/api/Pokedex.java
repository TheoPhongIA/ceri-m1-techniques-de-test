    package fr.univavignon.pokedex.api;

    import java.util.*;

    public class Pokedex implements IPokedex {

        private final List<Pokemon> pokemons;

        /**
         * Constructs a new Pokedex, initializing the list of Pokémon.
         */
        public Pokedex() {
            this.pokemons = new ArrayList<>();
        }

        /**
         * Returns the number of Pokémon in this Pokedex.
         *
         * @return the number of Pokémon in this Pokedex.
         */
        @Override
        public int size() {
            return pokemons.size();
        }

        /**
         * Adds the given Pokémon to this Pokedex and returns its unique index.
         *
         * @param pokemon the Pokémon to add to this Pokedex.
         * @return the index of the Pokémon relative to this Pokedex.
         */
        @Override
        public int addPokemon(Pokemon pokemon) {
            pokemons.add(pokemon);
            return pokemons.size() - 1; // the index is the position in the list
        }

        /**
         * Locates the Pokémon identified by the given id.
         *
         * @param id the unique Pokedex identifier.
         * @return the Pokémon denoted by the given identifier.
         * @throws PokedexException if the id is not valid.
         */
        @Override
        public Pokemon getPokemon(int id) throws PokedexException {
            if (id < 0 || id >= pokemons.size()) {
                throw new PokedexException("Invalid Pokedex ID: " + id);
            }
            return pokemons.get(id);
        }

        /**
         * Returns an unmodifiable list of all Pokémon in this Pokedex.
         *
         * @return unmodifiable list of all Pokémon.
         */
        @Override
        public List<Pokemon> getPokemons() {
            return Collections.unmodifiableList(pokemons);
        }

        /**
         * Returns an unmodifiable list of all Pokémon in this Pokedex, sorted by
         * the given Comparator.
         *
         * @param order the Comparator used for sorting the Pokémon list.
         * @return sorted unmodifiable list of all Pokémon.
         */
        @Override
        public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
            List<Pokemon> sortedList = new ArrayList<>(pokemons);
            Collections.sort(sortedList, order);
            return Collections.unmodifiableList(sortedList);
        }

        @Override
        public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
            return null;
        }

        @Override
        public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
            return null;
        }

        @Override
        public Collection<Object> getPokemonsMetadata() {
            return List.of();
        }
    }
