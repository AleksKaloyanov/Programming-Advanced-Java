package ListsEx;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> deck1 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> deck2 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!deck1.isEmpty() && !deck2.isEmpty()) {
            if (deck1.get(0) > deck2.get(0)) {
                deck1.add(deck1.size() - 1, deck1.remove(0));
                deck1.add(deck1.size() - 1, deck2.remove(0));
            } else if (deck1.get(0)<deck2.get(0)){
                deck2.add(deck2.size() - 1, deck2.remove(0));
                deck2.add(deck2.size() - 1, deck1.remove(0));
            } else {
                deck1.remove(0);
                deck2.remove(0);
            }
        }
        int sum = 0;
        if (!deck1.isEmpty()) {
            for (Integer integer : deck1) {
                sum += integer;
            }
            System.out.println("First player wins! Sum: " + sum);
        } else {
            for (Integer integer : deck2) {
                sum += integer;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }
    }
}