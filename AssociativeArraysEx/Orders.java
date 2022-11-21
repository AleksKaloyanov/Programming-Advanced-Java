package AssociativeArraysEx;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map<String, Double> products = new LinkedHashMap<>();
        Map<String, Integer> rememberQuantity = new HashMap<>();

        while (!input.equals("buy")) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!products.containsKey(name)) {
                products.put(name, price * quantity);
                rememberQuantity.put(name, quantity);
            } else {
                rememberQuantity.put(name, rememberQuantity.get(name) + quantity);
                products.put(name, rememberQuantity.get(name) * price);
            }
            input = sc.nextLine();
        }
        products
                .entrySet()
                .forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue()));
    }
}
