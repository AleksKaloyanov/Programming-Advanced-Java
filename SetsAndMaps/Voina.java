package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> player1 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> player2 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds-- > 0) {
            int card1 = player1.iterator().next();
            player1.remove(card1);
            int card2 = player2.iterator().next();
            player2.remove(card2);

            if (card1 > card2) {
                player1.addAll(Arrays.asList(card1, card2));
            } else if (card1 < card2) {
                player2.addAll(Arrays.asList(card1, card2));
            }

            if (player1.isEmpty() || player2.isEmpty()) {
                break;
            }
        }
        String output = "Draw!";
        if (player1.size() < player2.size()) {
            output = "Second player win!";
        } else if (player2.size() < player1.size()) {
            output = "First player win!";
        }
        System.out.println(output);
    }
}
