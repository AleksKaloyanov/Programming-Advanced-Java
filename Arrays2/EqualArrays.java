package Arrays2;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr1 = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] arr2 = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxLength = Math.max(arr1.length, arr2.length);

        boolean areEqual = true;
        for (int i = 0; i < maxLength; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areEqual = false;
                break;
            }
        }

        if (areEqual) {
            int sum = 0;
            for (int i = 0; i < maxLength; i++) {
                sum += arr1[i];
            }
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
