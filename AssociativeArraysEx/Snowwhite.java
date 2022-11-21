package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Snowwhite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();

        while (!"Once upon a time".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+<:>\\s+");
            String name = tokens[0];
            String color = tokens[1];
            int stats = Integer.parseInt(tokens[2]);

            putTheDwarf(name, color, stats, dwarfs);
        }

        Map<String, Integer> print = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : dwarfs.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
            }
        }

        print
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(), e1.getValue());

                    if (sort == 0) {
                        String[] size1 = e1.getKey().split(" ");
                        String[] size2 = e2.getKey().split(" ");

                        sort = size2[2].compareTo(size1[2]);
                    }
                    return sort;
                })
                .forEach(d -> {
                    String[] printing = d.getKey().split(" ");
                    System.out.printf("(%s) %s <-> %d%n", printing[0], printing[1], d.getValue());
                });
    }

    private static void putTheDwarf(String name, String color, int stats, Map<String, Map<String, Integer>> dwarfs) {
        dwarfs.putIfAbsent(color, new HashMap<>());
        if (dwarfs.get(color).containsKey(name)) {
            if (dwarfs.get(color).get(name) < stats) {
                dwarfs.get(color).put(name, stats);
            }
        } else {
            dwarfs.get(color).put(name, stats);
        }
    }
}
