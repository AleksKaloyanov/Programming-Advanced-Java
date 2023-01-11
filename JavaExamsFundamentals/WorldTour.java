package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorldTour {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(reader.readLine());

        String input = "";

        while (!"Travel".equals(input = reader.readLine())) {
            String[] tokens = input.split(":");
            String cmd = tokens[0];
            if ("Add Stop".equals(cmd)) {
                int index = Integer.parseInt(tokens[1]);
                String st = tokens[2];
                if (checkIndex(sb, index)) {
                    sb.insert(index, st);
                }
                System.out.println(sb);
            } else if ("Remove Stop".equals(cmd)) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]) +1;
                if (checkIndex(sb, startIndex, endIndex)) {
                    sb.replace(startIndex, endIndex, "");
                }
                System.out.println(sb);
            } else if ("Switch".equals(cmd)) {
                String old = tokens[1];
                String newS = tokens[2];
                String temp = sb.toString();
                if (temp.contains(old)) {
                    temp = temp.replace(old, newS);
                    sb = new StringBuilder(temp);
                }
                System.out.println(sb);
            }
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", sb);
    }

    private static boolean checkIndex(StringBuilder sb, int index) {
        return index >= 0 || index < sb.length();
    }
    private static boolean checkIndex(StringBuilder sb, int startIndex, int endIndex) {
        return startIndex >= 0 && endIndex <= sb.length();
    }
}