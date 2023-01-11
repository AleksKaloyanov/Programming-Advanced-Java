package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = reader.readLine();

        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[1];

            Predicate<String> predicate = null;

            if (cmd.equals("StartsWith")) {
                predicate = s -> s.startsWith(tokens[2]);
            } else if (cmd.equals("EndsWith")) {
                predicate = s -> s.endsWith(tokens[2]);
            } else if (cmd.equals("Length")) {
                predicate = s -> s.length() == Integer.parseInt(tokens[2]);
            }

            String removeOrDouble = tokens[0];

            if (removeOrDouble.equals("Remove")) {
                for (int i = 0; i < people.size(); i++) {
                    if (predicate.test(people.get(i))) {
                        people.remove(i);
                        i--;
                    }
                }
            } else {
                int size = people.size();
                for (int i = 0; i < size; i++) {
                    if (predicate.test(people.get(i))) {
                        people.add(people.get(i));
                    }
                }
            }

            input = reader.readLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            System.out.println(String.join(", ",people) + " are going to the party!");
        }
    }
}
