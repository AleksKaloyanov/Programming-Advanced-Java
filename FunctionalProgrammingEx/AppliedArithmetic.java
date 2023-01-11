package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(e -> e + 1).toArray();
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(e -> e - 1).toArray();
        Function<int[], int[]> multiply = arr -> Arrays.stream(arr).map(e -> e * 2).toArray();
        Consumer<int[]> consumer = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String input = "";

        while (!"end".equals(input = reader.readLine())) {
            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                    consumer.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
}
