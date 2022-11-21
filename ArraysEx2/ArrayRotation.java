package ArraysEx2;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayRotation  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int[] temp = new int[numbers.length];
            for (int j = 0; j < temp.length-1; j++) {
                temp[j]=numbers[j+1];
                temp[temp.length-1] = numbers[0];
            }
            numbers=temp;
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
