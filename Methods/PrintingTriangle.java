package Methods;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        createTriangle(n);
    }

    private static void createTriangle(int n) {
        createUpperHalf(n);
        createBottomHalf(n);
    }

    private static void createUpperHalf(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void createBottomHalf(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
