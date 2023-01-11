package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> function = e -> {
            int n = e.stream().min(Integer::compareTo).get();
            return list.lastIndexOf(n);
        };

        System.out.println(function.apply(list));
    }
}
