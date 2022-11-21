package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<String, Map<String, Integer>> courses = new LinkedHashMap<>();


        while (!"no more time".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+->\\s+");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            courses.putIfAbsent(contest, new LinkedHashMap<>());

            if (courses.get(contest).containsKey(username)) {
                if (courses.get(contest).get(username) < points) {
                    courses.get(contest).put(username, points);
                }
            } else {
                courses.get(contest).put(username, points);
            }
        }

        AtomicInteger num = new AtomicInteger(1);

        courses
                .forEach((key, value) -> {
                    num.set(1);
                    System.out.printf("%s: %d participants%n", key, value.size());
                    value
                            .entrySet()
                            .stream()
                            .sorted((n1, n2) -> {
                                int sort = Integer.compare(n2.getValue(), n1.getValue());
                                if (sort == 0) {
                                    sort = n1.getKey().compareTo(n2.getKey());
                                }
                                return sort;
                            })
                            .forEach(e -> {
                                System.out.printf("%d. %s <::> %d%n", num.getAndIncrement(), e.getKey(), e.getValue());
                            });
                });

        Map<String, Integer> standings = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : courses.entrySet()) {
            for (Map.Entry<String, Integer> students : entry.getValue().entrySet()) {
                standings.putIfAbsent(students.getKey(), 0);
                standings.put(students.getKey(), standings.get(students.getKey()) + students.getValue());
            }
        }
        num.set(1);
        System.out.println("Individual standings: ");

        standings
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = e2.getValue().compareTo(e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(s -> {
                    System.out.printf("%d. %s -> %d%n", num.getAndIncrement(), s.getKey(), s.getValue());
                });
    }
}
