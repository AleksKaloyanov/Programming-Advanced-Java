package SetsAndMapsEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = "";
        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input = sc.nextLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.put(name, number);
        }


        while (!"stop".equals(input = sc.nextLine())) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
