package DefiningClassesEx.PockemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Trainer> trainers = new LinkedList<>();

        String input = "";

        while (!"Tournament".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String nameT = tokens[0];
            String nameP = tokens[1];
            String el = tokens[2];
            int hp = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(nameP, el, hp);
            Trainer trainer = new Trainer(nameT);

            if (trainers.isEmpty()) {
                trainer.addPokemon(pokemon);
                trainers.add(trainer);
            } else {
                boolean hasTrainer = false;
                for (Trainer t : trainers) {
                    if (t.getName().equals(nameT)) {
                        t.addPokemon(pokemon);
                        hasTrainer = true;
                    }
                    if (!hasTrainer) {
                        trainer.addPokemon(pokemon);
                        trainers.add(trainer);
                        break;
                    }
                }
            }
        }

        while (!"End".equals(input = reader.readLine())) {
            for (Trainer trainer : trainers) {
                boolean hasPokemon = false;
                for (Pokemon pokemon : trainer.getPokemonList()) {
                    if (pokemon.getElement().equals(input)) {
                        trainer.giveBadge();
                        hasPokemon = true;
                    }
                }

                if (!hasPokemon) {
                    for (Pokemon pokemon : trainer.getPokemonList()) {
                        pokemon.removeHp();
                        if (pokemon.getHp() <= 0) {
                            trainer.getPokemonList().remove(pokemon);
                        }
                        if (trainer.getPokemonList().isEmpty()) {
                            break;
                        }
                    }
                }
            }
        }

        trainers.stream().
                sorted(Comparator.comparingInt(Trainer::getBadges).reversed()).
                forEach(t -> System.out.printf("%s %d %d%n", t.getName(), t.getBadges(), t.getPokemonList().size()));
    }
}
