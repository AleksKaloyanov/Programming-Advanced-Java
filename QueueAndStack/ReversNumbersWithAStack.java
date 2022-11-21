package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReversNumbersWithAStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int element : input) {
            numbers.push(element);
        }

        for (Integer number : numbers) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
