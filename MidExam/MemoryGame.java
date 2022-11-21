package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> sequence = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = sc.nextLine();

        int counter = 0;
        boolean hasWon = false;

        while (!input.equals("end") && !sequence.isEmpty()) {
            String[] tokens = input.split("\\s+");
            int firstIndex = Integer.parseInt(tokens[0]);
            int secondIndex = Integer.parseInt(tokens[1]);
            counter++;

            if (valid(firstIndex, secondIndex, sequence)) {

                if (equal(firstIndex, secondIndex, sequence)) {
                    int firstToRemove = Math.min(firstIndex, secondIndex);
                    int secondToRemove = Math.max(firstIndex, secondIndex);
                    sequence.remove(firstToRemove);
                    System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.remove(secondToRemove - 1));

                    if (sequence.isEmpty()) {
                        System.out.printf("You have won in %d turns!%n", counter);
                        hasWon = true;
                        break;
                    }
                } else {
                    System.out.println("Try again!");
                }
            } else {
                int middleIndex = sequence.size() / 2;
                sequence.add(middleIndex, "-" + counter + "a");
                sequence.add(middleIndex, "-" + counter + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }

            input = sc.nextLine();
        }
        if (!hasWon) {
            System.out.println("Sorry you lose :(");
            for (String s : sequence) {
                System.out.print(s + " ");
            }
        }
    }

    private static boolean equal(int firstIndex, int secondIndex, List<String> sequence) {
        return sequence.get(firstIndex).equals(sequence.get(secondIndex));
    }

    private static boolean valid(int firstIndex, int secondIndex, List<String> sequence) {
        return firstIndex >= 0 && secondIndex >= 0 && firstIndex != secondIndex
                && firstIndex < sequence.size() && secondIndex < sequence.size();
    }
}
