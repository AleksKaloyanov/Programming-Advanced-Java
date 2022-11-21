package DefiningClassesEx.PockemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }


    public void giveBadge() {
        this.badges++;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }
}
