package BasicExpresionsEx;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double total = 0;
        while (n-- > 0) {
            double orderPrice = 0;
            double pricePerCaps = Double.parseDouble(sc.nextLine());
            int days = Integer.parseInt(sc.nextLine());
            int capsCnt = Integer.parseInt(sc.nextLine());

            orderPrice = pricePerCaps*days*capsCnt;
            total+=orderPrice;
            System.out.printf("The price for the coffee is: $%.2f%n",orderPrice);
        }
        System.out.printf("Total: $%.2f",total);
    }
}
