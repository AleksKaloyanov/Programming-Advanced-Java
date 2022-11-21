package AssociativeArraysEx;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> items = new LinkedHashMap<>() {{
            put("shards", 0);
            put("fragments", 0);
            put("motes", 0);
        }};
        LinkedHashMap<String, Integer> junk = new LinkedHashMap<>();

        boolean isObtained = false;

        while (!isObtained) {
            String[] input = sc.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (items.containsKey(material)) {
                    addItem(items, material, quantity);
                    isObtained = hasLegendary(items, material);
                    if (isObtained) {
                        break;
                    }
                } else {
                    addItem(junk, material, quantity);
                }
            }
        }
        items
                .entrySet()
                .stream()
                .forEach(i -> System.out.printf("%s: %d%n", i.getKey(), i.getValue()));
        junk
                .entrySet()
                .forEach(j -> System.out.printf("%s: %d%n", j.getKey(), j.getValue()));
    }

    private static boolean hasLegendary(Map<String, Integer> map, String material) {
        int count = map.get(material);
        if (count >= 250) {
            map.put(material, count - 250);
            switch (material) {
                case "shards":
                    System.out.println("Shadowmourne obtained!");
                    return true;
                case "fragments":
                    System.out.println("Valanyr obtained!");
                    return true;
                case "motes":
                    System.out.println("Dragonwrath obtained!");
                    return true;
            }
        }
        return false;
    }

    private static void addItem(Map<String, Integer> map, String key, int value) {
        map.putIfAbsent(key, 0);
        map.put(key, map.get(key) + value);
    }
}
