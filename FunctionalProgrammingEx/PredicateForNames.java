package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split("\\s+");

        Predicate<String > predicate = e-> e.length()<=n;

        Arrays.stream(names).filter(predicate).forEach(System.out::println);
    }
}
