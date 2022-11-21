package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> numbers = new ArrayList<>();

        for (int i : input) {
            numbers.add(i);
        }
        List<Integer> numbersAfter = new ArrayList<>();

        for (int i = 0; i < numbers.size() / 2; i++) {
            numbersAfter.add(numbers.get(i)+numbers.get(numbers.size()-1-i));
        }
        if (numbers.size() % 2 == 1) {
            numbersAfter.add(numbers.get(numbers.size()/2));
        }

        for (Integer number : numbersAfter) {
            System.out.print(number+ " ");
        }
    }
}
