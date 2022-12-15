package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> count = arr -> {
            System.out.println("Count = " + numbers.length);
            return arr;
        };

        Function<int[], String> sum = arr -> "Sum = " + Arrays.stream(numbers).sum();

        System.out.println(count.andThen(sum).apply(numbers));


    }
}
