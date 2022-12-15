package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();

        printArr(arr);

        Arrays.sort(arr);

        printArr(arr);
    }

    private static void printArr(int[] arr) {
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
