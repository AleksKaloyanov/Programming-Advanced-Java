package Arrays2;

import java.util.Scanner;

public class PrintNumsInReverseOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(sc.nextLine());
            numbers[i] = input;
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
