package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        while (n != 0) {
            stack.push(n % 2);
            n /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
