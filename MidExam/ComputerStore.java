package MidExam;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        double total = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);

            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                total += price;
            }

            input = sc.nextLine();
        }

        if (total == 0) {
            System.out.println("Invalid order!");
        } else {
            double taxes = total * 0.2;
            double totalWithTaxes = total * 1.2;

            if (input.equals("special")) {
                double totalAfterDisc = totalWithTaxes * 0.9;
                System.out.printf("Congratulations you've just bought a new computer!%n" +
                        "Price without taxes: %.2f$%n" +
                        "Taxes: %.2f$%n" +
                        "-----------%n" +
                        "Total price: %.2f$%n",total,taxes,totalAfterDisc);
            }else {
                System.out.printf("Congratulations you've just bought a new computer!%n" +
                        "Price without taxes: %.2f$%n" +
                        "Taxes: %.2f$%n" +
                        "-----------%n" +
                        "Total price: %.2f$%n",total,taxes,totalWithTaxes);
            }
        }
    }
}
