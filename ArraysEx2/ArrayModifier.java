package ArraysEx2;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input = sc.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            String cmd = tokens[0];

            if (cmd.equals("multiply")) {
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);
                numbers[index1] *= numbers[index2];
            } else if (cmd.equals("swap")) {
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);
                int temp = numbers[index1];
                numbers[index1] = numbers[index2];
                numbers[index2] = temp;
            } else {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]--;
                }
            }
            input = sc.nextLine();
        }

        String separator = "";
        for (int number : numbers) {
            System.out.printf("%s%d",separator,number);
            separator= ", ";
        }
    }
}
