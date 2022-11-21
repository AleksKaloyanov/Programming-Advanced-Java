package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MOBAChallenger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<String, Map<String, Integer>> players = new HashMap<>();

        while (!"Season end".equals(input = reader.readLine())) {
            if (input.contains("->")) {
                String[] tokens = input.split("\\s+->\\s+");
                String name = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                players.putIfAbsent(name, new HashMap<>());
                players.get(name).putIfAbsent(position, -1);
                if (players.get(name).get(position) < skill) {
                    players.get(name).put(position, skill);
                }
            } else {
                String[] tokens = input.split("\\s+vs\\s+");
                String name1 = tokens[0];
                String name2 = tokens[1];

                if (playerExist(name1, players) && playerExist(name2, players)) {
                    if (commonDuel(name1, name2, players)) {
                        duel(name1, name2, players);

                    }
                }
            }
        }

        Map<String, Integer> points = new HashMap<>();
        players
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int sorted = sum2 - sum1;
                    if (sorted == 0) {
                        return sorted = e1.getKey().compareTo(e2.getKey());
                    }
                    return sorted;
                })
                .forEach(e -> {
                    System.out.printf("%s: %d skill%n", e.getKey(), e.getValue().values().stream().mapToInt(Integer::intValue).sum());
                    e.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> {
                                int sorted = e2.getValue().compareTo(e1.getValue());
                                if (sorted == 0) {
                                    return sorted = e1.getKey().compareTo(e2.getKey());
                                }
                                return sorted;
                            })
                            .forEach(p -> {
                                System.out.printf("- %s <::> %d%n", p.getKey(), p.getValue());
                            });
                });
    }

    private static void duel(String name1, String name2, Map<String, Map<String, Integer>> players) {
        int points1 = 0;
        int points2 = 0;

        for (Map.Entry<String, Map<String, Integer>> entry : players.entrySet()) {
            if (entry.getKey().equals(name1)) {
                points1 = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            } else if (entry.getKey().equals(name2)) {
                points2 = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            }
        }

        if (points1 < points2) {
            players.remove(name1);
        } else if (points2 < points1) {
            players.remove(name2);
        }
    }

    private static boolean commonDuel(String name1, String name2, Map<String, Map<String, Integer>> map) {
        Map<String, Integer> player1 = new HashMap<>();
        Map<String, Integer> player2 = new HashMap<>();

        for (Map.Entry<String, Map<String, Integer>> names : map.entrySet()) {
            for (Map.Entry<String, Integer> positions : names.getValue().entrySet()) {
                if (names.getKey().equals(name1)) {
                    player1.putIfAbsent(positions.getKey(), positions.getValue());
                } else {
                    player2.putIfAbsent(positions.getKey(), positions.getValue());
                }
            }
        }


        for (String s : player1.keySet()) {
            for (String s1 : player2.keySet()) {
                if (s.equals(s1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean playerExist(String name, Map<String, Map<String, Integer>> map) {
        return map.containsKey(name);
    }
}
