package Excercise;

import java.util.Arrays;
import java.util.Scanner;

public class SquareSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(calcSquareSum(arr));
    }

    private static int calcSquareSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.pow(i,2);
        }
        return sum;
    }
}
