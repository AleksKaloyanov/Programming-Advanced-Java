package ArraysEx2;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] num1 = new int[n];
        int[] num2 = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int[] tokens = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (cnt % 2 == 0) {
                num1[i] = tokens[0];
                num2[i] = tokens[1];
            }else {
                num1[i] = tokens[1];
                num2[i] = tokens[0];
            }
            cnt++;
        }

        for (int i : num1) {
            System.out.print(i +" ");
        }
        System.out.println();
        for (int i : num2) {
            System.out.print(i+ " ");
        }
    }
}
