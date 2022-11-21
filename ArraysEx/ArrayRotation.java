package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int firstElement = arr[0];
            for (int k = 0; k < arr.length - 1; k++) {
                arr[k] = arr[k + 1];
            }
            arr[arr.length - 1] = firstElement;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
