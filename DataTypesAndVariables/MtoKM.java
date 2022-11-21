package DataTypesAndVariables;

import java.util.Scanner;

public class MtoKM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        double mToKm = (double) m/1000;

        System.out.printf("%.2f",mToKm);
    }
}
