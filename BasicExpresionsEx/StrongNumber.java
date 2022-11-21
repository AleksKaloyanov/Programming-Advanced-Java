package BasicExpresionsEx;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int total = 0;

        for (int i = 0; i < input.length(); i++) {
            int n = Integer.parseInt("" +input.charAt(i));
            int currentSum = 1;
            for (int j = n; j >= 1; j--) {
                currentSum *=j;
            }
            total+=currentSum;
        }

        if (Integer.parseInt(input) == total) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
