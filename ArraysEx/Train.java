package ArraysEx;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println();
        System.out.println(sum);
    }
}
