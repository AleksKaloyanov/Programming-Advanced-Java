package ListsEx;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!numbers.isEmpty()) {
            int input = Integer.parseInt(sc.nextLine());
            if (input > numbers.size() - 1) {
                int number = numbers.remove(numbers.size() - 1);
                numbers.add(numbers.size(), numbers.get(0));
                sumAndSub(numbers, number);
                sum += number;
            } else if (input < 0) {
                int number = numbers.remove(0);
                numbers.add(0, numbers.get(numbers.size() - 1));
                sumAndSub(numbers, number);
                sum += number;
            } else {
                int number = numbers.remove(input);
                sumAndSub(numbers, number);
                sum += number;
            }
        }
        System.out.println(sum);
    }

    private static void sumAndSub(List<Integer> numbers, int number) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > number) {
                numbers.set(i, numbers.get(i) - number);
            } else {
                numbers.set(i, numbers.get(i) + number);
            }
        }
    }
}
