package MidExam;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            int index = Integer.parseInt(tokens[1]);

            if (cmd.equals("Shoot")) {

                if (valid(index, numbers)) {
                    int power = Integer.parseInt(tokens[2]);
                    numbers.set(index, numbers.get(index) - power);

                    if (numbers.get(index) <= 0) {
                        numbers.remove(index);
                    }
                }
            } else if (cmd.equals("Add")) {

                if (valid(index, numbers)) {
                    int value = Integer.parseInt(tokens[2]);
                    numbers.add(index, value);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else {
                int radius = Integer.parseInt(tokens[2]);

                if (valid(index, radius, numbers)) {
                    int diameter = radius * 2;
                    for (int i = 0; i < diameter + 1; i++) {
                        numbers.remove(index - radius);
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }

            input = sc.nextLine();
        }

        String separator = "";
        for (Integer number : numbers) {
            System.out.print(separator + number);
            separator = "|";
        }
    }

    private static boolean valid(int index, int radius, List<Integer> numbers) {
        return index - radius >= 0 && index + radius < numbers.size();
    }

    private static boolean valid(int index, List<Integer> numbers) {
        return index >= 0 && index < numbers.size();
    }
}
