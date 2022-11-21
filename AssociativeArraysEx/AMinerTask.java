package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        int counter = 0;
        String resource = "";

        while (!input.equals("stop")) {
            counter++;

            if (counter % 2 == 1) {
                resources.putIfAbsent(input, 0);
                resource = input;
            } else {
                int value = Integer.parseInt(input);
                resources.put(resource, resources.get(resource) + value);
            }
            input = sc.nextLine();
        }

        resources
                .forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
