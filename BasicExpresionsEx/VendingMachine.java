package BasicExpresionsEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        double total = 0;
        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                total += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            input = sc.nextLine();
        }

        Map<String, Double> products = new HashMap<>();
        products.put("Nuts", 2.0);
        products.put("Water", 0.7);
        products.put("Crisps", 1.5);
        products.put("Soda", 0.8);
        products.put("Coke", 1.0);

        input = sc.nextLine();

        while (!input.equals("End")) {
            double price = products.get(input);
            if (products.containsKey(input)) {
                if (price <= total) {
                    System.out.printf("Purchased %s%n", input);
                    total -= price;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }
            input = sc.nextLine();
        }
        System.out.printf("Change: %.2f", total);

    }
}
