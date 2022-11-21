package Lists;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(number -> number < 0);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            Collections.reverse(numbers);
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        }
    }
}
