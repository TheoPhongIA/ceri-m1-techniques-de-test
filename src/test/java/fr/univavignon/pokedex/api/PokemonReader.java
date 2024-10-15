package fr.univavignon.pokedex.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonReader {
    private List<Pokemon> pokemons; // Liste des objets Pokémon

    // Constructeur qui lit le fichier et initialise la liste
    public PokemonReader(String filePath) {
        this.pokemons = new ArrayList<>();
        loadPokemons(filePath); // Charge les Pokémon lors de l'initialisation
    }

    // Méthode pour charger les Pokémon depuis le fichier
    private void loadPokemons(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Diviser la ligne en attributs
                String[] attributes = line.split(",");
                if (attributes.length == 10) { // Vérifier que la ligne contient tous les attributs
                    int index = Integer.parseInt(attributes[0]);
                    String name = attributes[1].replace("\"","");
                    int attack = Integer.parseInt(attributes[2]);
                    int defense = Integer.parseInt(attributes[3]);
                    int stamina = Integer.parseInt(attributes[4]);
                    int cp = Integer.parseInt(attributes[5]);
                    int hp = Integer.parseInt(attributes[6]);
                    int dust = Integer.parseInt(attributes[7]);
                    int candy = Integer.parseInt(attributes[8]);
                    double iv = Double.parseDouble(attributes[9]);

                    // Créer un nouvel objet Pokémon et l'ajouter à la liste
                    Pokemon pokemon = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
                    pokemons.add(pokemon);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    // Méthode pour obtenir la liste des Pokémon
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
}
