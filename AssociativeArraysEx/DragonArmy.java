package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            int dmg = Integer.parseInt(checkValue(tokens[2], 1));
            int health = Integer.parseInt(checkValue(tokens[3], 2));
            int armor = Integer.parseInt(checkValue(tokens[4], 3));

            putDragon(type, name, dmg, health, armor, dragons);
        }

        dragons
                .entrySet()
                .forEach(e -> {
                    double avgDmg = 0.0;
                    double avgHP = 0.0;
                    double avgArmor = 0.0;

                    for (Map.Entry<String, int[]> d : e.getValue().entrySet()) {
                        double[] stats = Arrays.stream(d.getValue()).asDoubleStream().toArray();
                        int size = e.getValue().size();
                        avgDmg += stats[0] / size;
                        avgHP += stats[1] / size;
                        avgArmor += stats[2] / size;
                    }
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(),
                            avgDmg, avgHP, avgArmor);

                    e.getValue()
                            .entrySet()
                            .forEach(d -> {
                                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", d.getKey(),
                                        d.getValue()[0], d.getValue()[1], d.getValue()[2]);
                            });
                });
    }

    private static void putDragon(String type, String name, int dmg, int health, int armor, Map<String, TreeMap<String, int[]>> dragons) {
        dragons.putIfAbsent(type, new TreeMap<>());
        int[] currentDragon = {dmg, health, armor};
        if (!dragons.get(type).containsKey(name)) {
            dragons.get(type).put(name, currentDragon);
        } else {
            dragons.get(type).remove(name);
            dragons.get(type).put(name, currentDragon);
        }
    }

    public static String checkValue(String s, int n) {
        switch (n) {
            case 1:
                if (s.equals("null")) {
                    s = "45";
                    break;
                }
            case 2:
                if (s.equals("null")) {
                    s = "250";
                    break;
                }
            case 3:
                if (s.equals("null")) {
                    s = "10";
                    break;
                }
        }
        return s;
    }
}