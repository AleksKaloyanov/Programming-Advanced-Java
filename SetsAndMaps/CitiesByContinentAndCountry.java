package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, List<String>>> earth = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] tokens = input.split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String town = tokens[2];

            earth.putIfAbsent(continent, new LinkedHashMap<>());
            earth.get(continent).putIfAbsent(country, new LinkedList<>());
            earth.get(continent).get(country).add(town);
        }

        earth.entrySet()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    e.getValue().entrySet()
                            .forEach(c -> {
                                System.out.printf("%s -> %s%n", c.getKey(), getTowns(c.getValue()));
                            });
                });
    }

    private static String getTowns(List<String> value) {
        String output = "";
        String sp = "";
        for (String s : value) {
            output += sp + s;
            sp = ", ";
        }
        return output;
    }
}
