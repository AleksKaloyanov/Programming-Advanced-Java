package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleCalc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] symbols = reader.readLine().split("\\s+");

        if (symbols.length == 0) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(symbols[0]));

        for (int i = 1; i < symbols.length; i++) {
            String operation = symbols[i];
            int num = Integer.parseInt(symbols[++i]);
            int stackNum = stack.pop();

            if ("+".equals(operation)) {
                stack.push(num + stackNum);
            } else {
                stack.push(stackNum - num);
            }
        }
        System.out.println(stack.peek());
    }
}
