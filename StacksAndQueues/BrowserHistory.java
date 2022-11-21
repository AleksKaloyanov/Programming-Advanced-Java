package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        ArrayDeque<String> urlStack = new ArrayDeque<>();

        while (!"Home".equals(input = reader.readLine())) {
            if (input.equals("back")) {
                if (urlStack.isEmpty() || urlStack.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    urlStack.pop();
                    System.out.println(urlStack.peek());
                }
            } else {
                urlStack.push(input);
                System.out.println(urlStack.peek());
            }
        }
    }
}
