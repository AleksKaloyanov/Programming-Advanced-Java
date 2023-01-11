package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Integer> predicates = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Predicate<Integer> predicate = e -> {
            boolean isDivisible = true;
            for (int i = 1; i <= n; i++) {
                isDivisible = true;
                for (Integer p : predicates) {
                    if (i % p != 0) {
                        isDivisible = false;
                        break;
                    }
                }
                if (isDivisible) {
                    System.out.print(i + " ");
                }
            }
            return isDivisible;
        };

        predicate.test(n);
    }
}
