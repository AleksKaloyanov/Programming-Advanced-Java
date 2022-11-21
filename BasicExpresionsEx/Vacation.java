package BasicExpresionsEx;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String type = sc.nextLine();
        String day = sc.nextLine();

        double price = 0;
        double totalPrice = 0;
        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }break;
        }
        totalPrice = price*n;

        if (type.equals("Students") && n > 29) {
            totalPrice*=0.85;
            System.out.printf("Total price: %.2f",totalPrice);
        }else if (type.equals("Business") && n > 99) {
            totalPrice = price * (n-10);
            System.out.printf("Total price: %.2f",totalPrice);
        }else if (type.equals("Regular") && n >9 && n<21) {
            totalPrice*=0.95;
            System.out.printf("Total price: %.2f",totalPrice);
        }else {
            System.out.printf("Total price: %.2f",totalPrice);
        }
    }
}
