package ArraysEx2;

import java.util.Scanner;
import java.util.Arrays;

public class EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int indexBest=0;
        boolean exists = false;

        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            int sumLeft = 0;
            int sumRight=0;
            for (int j = i+1; j < numbers.length; j++) {
                sumLeft+=numbers[j];
            }
            for (int j = i-1; j >=0; j--) {
                sumRight+=numbers[j];
            }
            if (sumLeft==sumRight){
                indexBest = i;
                exists=true;
            }
        }
        if (exists) {
            System.out.println(indexBest);
        }else {
            System.out.println("no");
        }
    }
}
