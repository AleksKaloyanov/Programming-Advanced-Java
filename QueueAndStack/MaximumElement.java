package QueueAndStack;


import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            if (cmd.equals("1")) {
                numbers.push(Integer.parseInt(tokens[1]));
            } else if (cmd.equals("2")) {
                numbers.pop();
            } else {
                System.out.println(Collections.max(numbers));
            }
        }

    }
}