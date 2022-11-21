package DataTypesAndVariables;

import java.util.Scanner;

public class RefactorSpecialNums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean isSpecial = false;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            isSpecial = sum == 5 || sum == 7 || sum == 11;
            System.out.printf("%d -> %b%n", num, isSpecial);
        }

    }
}
