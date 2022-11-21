package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Deque<String> printer = new ArrayDeque<>();
        while (!"print".equals(input = reader.readLine())) {
            if (input.equals("cancel")) {
                if (printer.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printer.poll());
                }
            } else {
                printer.offer(input);
            }
        }
        while (!printer.isEmpty()) {
            System.out.println(printer.poll());
        }
    }
}
