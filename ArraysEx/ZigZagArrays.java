package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i % 2 == 0) {
                arr1[i] = input[0];
                arr2[i] = input[1];
            } else {
                arr1[i] = input[1];
                arr2[i] = input[0];
            }
        }
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
