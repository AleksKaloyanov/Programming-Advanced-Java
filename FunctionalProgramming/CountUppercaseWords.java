package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        Predicate<String> predicate = s -> Character.isUpperCase(s.charAt(0));

        StringBuilder sb = new StringBuilder();
        AtomicInteger counter = new AtomicInteger();

        Consumer<String> consumer = s -> {
            counter.getAndIncrement();
            sb.append(s).append(System.lineSeparator());
        };

        Arrays
                .stream(input)
                .filter(predicate)
                .forEach(consumer);

        System.out.println(counter);
        System.out.println(sb);
    }
}
