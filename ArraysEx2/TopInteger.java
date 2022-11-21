package ArraysEx2;

import java.util.Scanner;
import java.util.Arrays;

public class TopInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNum = numbers[i];
            boolean isTop = true;
            for (int j = i+1; j < numbers.length; j++) {
                if (currentNum <= numbers[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(currentNum + " ");
            }
        }
        if (numbers.length - 1 != 0) {
            System.out.print(numbers[numbers.length-1]);
        }
    }
}
