package MidExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = sc.nextLine();

        List<Integer> shotIndexes = new ArrayList<>();
        int counter = 0;

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            int index = Integer.parseInt(tokens[0]);

            if (valid(index, numbers, shotIndexes)) {
                shotIndexes.add(index);
                int targetNumber = numbers[index];
                numbers[index] = -1;

                for (int i = 0; i < numbers.length; i++) {

                    if (numbers[i] != -1) {

                        if (numbers[i] > targetNumber) {
                            numbers[i] -= targetNumber;
                        } else {
                            numbers[i] += targetNumber;
                        }
                    }
                }
                counter++;
            }
            input=sc.nextLine();
        }
        System.out.print("Shot targets: "+ counter+" -> ");
        for (int number : numbers) {
            System.out.print(number+" ");
        }
    }

    private static boolean valid(int index, int[] numbers, List<Integer> shotIndexes) {
        return index >= 0 && index < numbers.length && !shotIndexes.contains(index);
    }
}
