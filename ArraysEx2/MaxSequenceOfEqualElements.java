package ArraysEx2;

import java.util.Scanner;
import java.util.Arrays;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        int cntBest = 0;
        int bestNum= 0;
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            int cnt = 0;
            for (int j = i+1; j < numbers.length; j++) {
                if (current==numbers[j]){
                    cnt++;
                }else {
                    break;
                }
            }
            if (cntBest < cnt) {
                bestNum = numbers[i];
                cntBest=cnt;
            }
        }

        for (int i = 0; i <= cntBest; i++) {
            System.out.print(bestNum+" ");
        }
    }
}
