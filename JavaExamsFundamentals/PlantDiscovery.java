package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> plants = new LinkedHashMap<>();
        Map<String, List<Double>> ratingList = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("<->");
            String plant = tokens[0];
            String rarity = tokens[1];

            plants.putIfAbsent(plant, "");
            plants.put(plant, rarity);
            ratingList.putIfAbsent(plant, new ArrayList<>());
        }

        String input = "";

        while (!"Exhibition".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String cmd = tokens[0];
            if ("Rate".equals(cmd)) {
                String[] tok = tokens[1].split("\\s+-\\s+");
                String plant = tok[0].trim();
                Double rating = Double.parseDouble(tok[1]);
                if (plants.containsKey(plant)) {
                    ratingList.get(plant).add(rating);
                } else {
                    getError();
                }
            } else if ("Update".equals(cmd)) {
                String[] tok = tokens[1].split("\\s+-\\s+");
                String plant = tok[0].trim();
                String rarity = tok[1];
                if (plants.containsKey(plant)) {
                    plants.put(plant, rarity);
                } else {
                    getError();
                }
            } else if ("Reset".equals(cmd)) {
                String plant = tokens[1].trim();
                if (plants.containsKey(plant)) {
                    ratingList.get(plant).clear();
                } else {
                    getError();
                }
            }
        }

        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, String> e : plants.entrySet()) {
            System.out.printf("- %s; Rarity: %s; Rating: ", e.getKey(), e.getValue());
            if (ratingList.get(e.getKey()).size() == 0) {
                System.out.print("0.00");
                System.out.println();
            } else {
                System.out.printf("%.2f%n", ratingList.get(e.getKey())
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .getAsDouble());
            }
        }
    }

    private static void getError() {
        System.out.println("error");
    }
}
