package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                int startIndex = stack.pop();
                String contents = input.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
