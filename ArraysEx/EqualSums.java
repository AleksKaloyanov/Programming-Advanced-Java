package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean areEqual = true;

        int divider = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int k = 0; k < i; k++) {
                leftSum+=arr[k];
            }
            for (int j = i+1; j < arr.length; j++) {
                rightSum+=arr[j];
            }
            if (leftSum - rightSum == 0) {
                divider = i;
                areEqual=true;
                break;
            }else {
                areEqual=false;
            }
        }
        if (areEqual) {
            System.out.println(divider);
        }else {
            System.out.println("no");
        }
    }
}
