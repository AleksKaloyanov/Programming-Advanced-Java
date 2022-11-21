package BasicExpresionsEx;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();
        if (age >= 0 && age <= 2) {
            System.out.println("baby");
        } else if (age > 2 && age < 14) {
            System.out.println("child");
        } else if (age > 13 && age < 20) {
            System.out.println("teenager");
        } else if (age > 19 && age < 66) {
            System.out.println("adult");
        } else if (age > 65) {
            System.out.println("elder");
        }
    }
}
