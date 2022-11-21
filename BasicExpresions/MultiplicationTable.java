package BasicExpresions;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int multiplier = sc.nextInt();
        if (multiplier > 10) {
            System.out.println(n + " X " + multiplier + " = " + multiplier * n);
        } else {
            for (int i = multiplier; i <= 10; i++) {
                System.out.println(n + " X " + i + " = " + i * n);
            }
        }
    }
}