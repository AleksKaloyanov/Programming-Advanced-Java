package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int numbersToRemove = input[1];
        int checkNumber = input[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbers.push(sc.nextInt());
        }

        for (int i = 0; i < numbersToRemove; i++) {
            numbers.pop();
        }

        if (numbers.contains(checkNumber)) {
            System.out.println("true");
        } else if (numbers.isEmpty()) {
            System.out.println(0);
        } else {
            int smallest = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number < smallest) {
                    smallest = number;
                }
            }
            System.out.println(smallest);
        }
    }
}



