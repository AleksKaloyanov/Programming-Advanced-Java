package Methods2;

import java.util.Scanner;

public class PrintATriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        printTriangle(n);
    }

    private static void printTriangle(int n) {
        printUpperPart(n);
        printLowerPart(n);
    }

    private static void printUpperPart(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void printLowerPart(int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.println();
        }
    }
}
