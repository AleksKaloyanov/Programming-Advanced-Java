package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEven =0;
        int sumOdd =0;

        for (int i : input) {
            if (i % 2 == 0) {
                sumEven+=i;
            }else {
                sumOdd+=i;
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
