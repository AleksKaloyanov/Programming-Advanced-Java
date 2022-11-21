package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int num = input[0];
        int pop = input[1];
        int cont = input[2];

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            numbers.add(sc.nextInt());
        }

        for (int i = 0; i < pop; i++) {
            numbers.pop();
        }


        boolean isTrue = false;
        for (Integer number : numbers) {
            if (number == cont) {
                System.out.println("true");
                isTrue = true;
            }
        }
        if (numbers.isEmpty()) {
            System.out.println(0);
        } else if (!isTrue) {
            System.out.println(Collections.min(numbers));
        }
    }
}
