package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int[] boundaries = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String cmd = reader.readLine();

        switch (cmd) {
            case "odd":
                Predicate<Integer> pOdd = n -> n % 2 != 0;
                print(boundaries, pOdd);
                break;
            case "even":
                Predicate<Integer> pEven = n -> n % 2 == 0;
                print(boundaries, pEven);
                break;
        }
    }

    private static void print(int[] boundaries, Predicate<Integer> predicate) {
        for (int i = boundaries[0]; i <= boundaries[1]; i++) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
