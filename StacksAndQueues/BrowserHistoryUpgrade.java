package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!"Home".equals(input = reader.readLine())) {
            if (input.equals("back")) {
                if (back.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(back.pop());
                    System.out.println(back.peek());
                }
            } else if (input.equals("forward")) {
                if (forward.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    back.push(forward.pop());
                }
            } else {
                System.out.println(input);
                back.push(input);
                forward.clear();
            }
        }
    }
}
