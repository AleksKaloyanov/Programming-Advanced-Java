package DefiningClassesEx.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        String input = "";

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String type = tokens[1];
            people.putIfAbsent(name, new Person(name));
            if (type.equals("company")) {
                String compName = tokens[2];
                String deptName = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                people.get(name).setCompany(new Company(compName, deptName, salary));

            } else if (type.equals("car")) {
                String model = tokens[2];
                int speed = Integer.parseInt(tokens[3]);
                people.get(name).setCar(new Car(model, speed));

            } else if (type.equals("pokemon")) {
                String pokeName = tokens[2];
                String element = tokens[3];
                people.get(name).addPokemon(new Pokemon(pokeName, element));

            } else if (type.equals("parents")) {
                String parentName = tokens[2];
                String birthDate = tokens[3];
                people.get(name).addParents(new Parent(parentName, birthDate));
            } else {
                String childName = tokens[2];
                String birthDate = tokens[3];
                people.get(name).addChild(new Child(childName, birthDate));
            }
        }

        String toPrint = reader.readLine();

        if (people.containsKey(toPrint)) {
            people.entrySet()
                    .stream().filter(v -> v.getKey().equals(toPrint))
                    .forEach(p -> {
                        System.out.println(p.getValue().getName());
                        System.out.println("Company:");
                        if (p.getValue().getCompany() != null) {
                            System.out.println(p.getValue().getCompany().toString());
                        }
                        System.out.println("Car:");
                        if (p.getValue().getCar() != null) {
                            System.out.println(p.getValue().getCar().toString());
                        }
                        System.out.println("Pokemon:");
                        if (!p.getValue().getPokemons().isEmpty()) {
                            for (Pokemon pokemon : p.getValue().getPokemons()) {
                                System.out.println(pokemon.toString());
                            }
                        }
                        System.out.println("Parents:");
                        if (!p.getValue().getParents().isEmpty()) {
                            for (Parent parent : p.getValue().getParents()) {
                                System.out.println(parent.toString());
                            }
                        }
                        System.out.println("Children:");
                        if (!p.getValue().getChildren().isEmpty()) {
                            for (Child child : p.getValue().getChildren()) {
                                System.out.println(child.toString());
                            }
                        }
                    });
        }
    }
}
