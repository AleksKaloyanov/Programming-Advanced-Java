package AssociativeArraysEx;


import java.util.LinkedHashMap;

import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] input = sc.nextLine().toCharArray();

        LinkedHashMap<Character, Integer> counts = new LinkedHashMap<>();

        for (char c : input) {
            if (c == ' ') {
                continue;
            }

            counts.putIfAbsent(c, 0);
            int count = counts.get(c);
            counts.put(c, count + 1);
        }

        counts.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
