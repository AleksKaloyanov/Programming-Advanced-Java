package BasicExpresions;

import java.util.Scanner;

public class SumOfOddNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum+= i*2 -1;
            System.out.println(i*2-1);
        }
        System.out.printf("Sum: %d",sum);
    }
}
