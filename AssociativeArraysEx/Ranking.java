package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> passwords = new HashMap<>();

        String input = "";

        Map<String, Map<String, Integer>> students = new TreeMap<>();

        while (!"end of contests".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            passwords.put(contest, password);
        }

        while (!"end of submissions".equals(input = reader.readLine())) {
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (passwords.containsKey(contest) && passwords.get(contest).equals(password)) {
                if (students.containsKey(username)) {
                    if (students.get(username).containsKey(contest)) {
                        if (students.get(username).get(contest) < points) {
                            students.get(username).put(contest, points);
                        }
                    } else {
                        students.get(username).put(contest, points);
                    }
                } else {
                    students.put(username, new HashMap<>());
                    students.get(username).put(contest, points);
                }
            }
        }
        int totalSum = 0;
        String bestName = "";


        for (Map.Entry<String, Map<String, Integer>> e : students.
                entrySet()) {
            int sum = e.getValue().values().stream().mapToInt(Integer::intValue).sum();
            if (totalSum < sum) {
                totalSum = sum;
                bestName = e.getKey();
            }
        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestName, totalSum);

        System.out.println("Ranking: ");

        students.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value
                    .entrySet()
                    .stream()
                    .sorted((c1, c2) -> c2.getValue() - c1.getValue())
                    .forEach(c -> System.out.printf("#  %s -> %d%n", c.getKey(), c.getValue()));
        });
    }
}

