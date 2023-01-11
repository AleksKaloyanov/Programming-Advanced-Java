package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Pirates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> cities = new LinkedHashMap<>();
        String input = "";

        while (!"Sail".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int pop = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            cities.putIfAbsent(city, new ArrayList<>());
            if (cities.get(city).isEmpty()) {
                cities.get(city).add(pop);
                cities.get(city).add(gold);
            } else {
                cities.get(city).set(0, cities.get(city).get(0) + pop);
                cities.get(city).set(1, cities.get(city).get(1) + gold);
            }
        }
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("=>");
            String cmd = tokens[0];
            String city = tokens[1];
            int currentPop = cities.get(city).get(0);
            int currentGold = cities.get(city).get(1);
            if ("Plunder".equals(cmd)) {
                int people = Integer.parseInt(tokens[2]);
                int gold = Integer.parseInt(tokens[3]);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, gold, people);
                if (currentPop - people <= 0 || currentGold - gold <= 0) {
                    cities.remove(city);
                    System.out.println(city + " has been wiped off the map!");
                } else {
                    cities.get(city).set(0, currentPop - people);
                    cities.get(city).set(1, currentGold - gold);
                }
            } else if ("Prosper".equals(cmd)) {
                int gold = Integer.parseInt(tokens[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cities.get(city).set(1, currentGold + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, city,
                            cities.get(city).get(1));
                }
            }
        }
        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.forEach((key, value) -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", key,
                    value.get(0), value.get(1)));
        }
    }
}
