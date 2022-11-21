package SetsAndMapsEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<String, Set<String>> hands = new LinkedHashMap<>();
        while (!"JOKER".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String name = tokens[0];

            String[] cards = tokens[1].split(",\\s+");

            hands.putIfAbsent(name, new HashSet<>());
            for (String card : cards) {
                hands.get(name).add(card.trim());
            }
        }

        hands.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), calcValue(e.getValue())));
                });
    }

    private static int calcValue(Set<String> value) {
        int sum = 0;
        for (String s : value) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(1);
            int multiplier = 0;
            int cardValue = 0;
            if (s.length() == 3) {
                c1 = 58;
                c2 = s.charAt(2);
            }
            if (c2 == 'S') multiplier = 4;
            else if (c2 == 'H') {
                multiplier = 3;
            } else if (c2 == 'D') {
                multiplier = 2;
            } else if (c2 == 'C') {
                multiplier = 1;
            }
            if (c1 == 'J') cardValue = 11;
            else if (c1 == 'Q') {
                cardValue = 12;
            } else if (c1 == 'K') {
                cardValue = 13;
            } else if (c1 == 'A') {
                cardValue = 14;
            } else {
                cardValue = c1 - 48;
            }
            sum += cardValue * multiplier;
        }
        return sum;
    }
}
