package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        for (int i : arr) {
            if (i%2 == 0){
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
