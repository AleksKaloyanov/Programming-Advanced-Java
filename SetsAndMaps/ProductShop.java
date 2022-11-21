package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = "";

        while (!"Revision".equals(input = sc.nextLine())) {
            String[] tokens = input.split(",\\s+");
            String name = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(name, new LinkedHashMap<>());
            shops.get(name).put(product, price);
        }

        shops.forEach((key1, value1) -> {
            System.out.println(key1 + "->");
            value1.forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
        });
    }
}
