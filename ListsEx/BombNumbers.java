package ListsEx;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bomb = input[0];
        int power = input[1];

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);

            int leftBound = Math.max(index - power, 0);
            int rightBound = Math.min(index + power, numbers.size() - 1);

            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }
        int sum =0;
        for (Integer number : numbers) {
            sum+=number;
        }
        System.out.println(sum);
    }
}
