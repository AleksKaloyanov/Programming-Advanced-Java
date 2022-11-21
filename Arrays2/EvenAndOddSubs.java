package Arrays2;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEven = 0;
        int sumOdd = 0;

        for (int n : num) {
            if (n % 2 == 0) {
                sumEven+=n;
            }else {
                sumOdd+=n;
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
