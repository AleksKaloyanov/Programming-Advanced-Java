package ArraysEx2;

import java.util.Scanner;
import java.util.Arrays;

public class MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (current + numbers[j] == n) {
                    System.out.println(current + " "+numbers[j]);
                }
            }
        }
    }
}
