package DataTypesAndVariablesEx;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int yield = Integer.parseInt(sc.nextLine());

        int counter = 0;

        if (yield >= 100) {
            int total = 0;

            while (yield >= 100) {
                counter++;

                total += yield;
                total -= 26;

                yield -= 10;
            }
            total-=26;
            System.out.printf("%d%n%d%n",counter,total);
        }else {
            System.out.println(0);
            System.out.println(0);
        }
    }
}
