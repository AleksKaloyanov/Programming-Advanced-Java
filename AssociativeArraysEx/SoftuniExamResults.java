package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SoftuniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<String, List<Integer>> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while (!"exam finished".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            if (!tokens[1].equals("banned")) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                results.putIfAbsent(name, new ArrayList<>());
                results.get(name).add(points);

                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);
            } else {
                results.remove(name);
            }
        }

        System.out.println("Results:");
        results
                .forEach((key, value) -> {
                    System.out.printf("%s | ", key);
                    System.out.printf("%d%n", value
                            .stream()
                            .max(Comparator.comparing(Integer::valueOf))
                            .get());
                });

        System.out.println("Submissions:");
        submissions
                .forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }
}
