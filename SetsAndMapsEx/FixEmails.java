package SetsAndMapsEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> people = new LinkedHashMap<>();

        String input = "";

        while (!"stop".equals(input = sc.nextLine())) {
            String email = sc.nextLine();
            String[] tokens = email.split("\\.");
            String postFix = tokens[tokens.length - 1];

            if (!(postFix.equals("us") || postFix.equals("uk") || postFix.equals("com"))) {
                people.putIfAbsent(input, email);
            }
        }

        people.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
