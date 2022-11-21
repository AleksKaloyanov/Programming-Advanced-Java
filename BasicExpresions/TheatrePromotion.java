package BasicExpresions;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        int price = 0;

        switch (day) {
            case "Weekday":
                if (age >= 0 && age <= 18 || age > 64 && age < 123) {
                    price = 12;
                } else if (age > 18 && age < 65) {
                    price = 18;
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18 || age > 64 && age < 123) {
                    price = 15;
                } else if (age > 18 && age < 65) {
                    price = 20;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                } else if (age > 18 && age < 65) {
                    price = 12;
                } else if (age > 64 && age < 123) {
                    price = 10;
                }
                break;
        }
        if (price == 0) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", price);
        }
    }
}