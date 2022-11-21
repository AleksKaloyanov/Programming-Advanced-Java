package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] firstArr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        boolean areIdentical = true;
        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] == secondArr[i]) {
                sum += firstArr[i];
            } else {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areIdentical = false;
                break;
            }
        }
        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d",sum);
        }
    }
}
