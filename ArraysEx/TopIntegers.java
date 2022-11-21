package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                output.append(arr[i]).append(" ");
            }
        }
        output.append(arr[arr.length-1]);
        System.out.println(output);
    }
}
