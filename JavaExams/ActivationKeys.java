package JavaExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivationKeys {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String rawKey = reader.readLine();

        String input = "";

        while (!"Generate".equals(input = reader.readLine())) {
            String[] tokens = input.split(">>>");
            String cmd = tokens[0];

            if ("Contains".equals(cmd)) {
                String sub = tokens[1];
                if (rawKey.contains(sub)) {
                    System.out.println(rawKey + " contains " + sub);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if ("Flip".equals(cmd)) {
                String cmd2 = tokens[1];
                int start = Integer.parseInt(tokens[2]);
                int end = Integer.parseInt(tokens[3]);
                if ("Upper".equals(cmd2)) {
                    String subStart = rawKey.substring(0, start);
                    String subUP = rawKey.substring(start, end).toUpperCase();
                    String subEnd = rawKey.substring(end);
                    rawKey = subStart + subUP + subEnd;
                    System.out.println(rawKey);
                } else if ("Lower".equals(cmd2)) {
                    String subStart = rawKey.substring(0, start);
                    String subLow = rawKey.substring(start, end).toLowerCase();
                    String subEnd = rawKey.substring(end);
                    rawKey = subStart + subLow + subEnd;
                    System.out.println(rawKey);
                }
            } else if ("Slice".equals(cmd)) {
                int start = Integer.parseInt(tokens[1]);
                int end = Integer.parseInt(tokens[2]);
                String sub = rawKey.substring(0, start);
                String sub1 = rawKey.substring(end);
                rawKey = sub + sub1;
                System.out.println(rawKey);
            }
        }
        System.out.println("Your activation key is: " + rawKey);
    }
}
