package FunctionalProgrammingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = reader.readLine();

        List<String> removedPpl = new ArrayList<>();

        while (!"Print".equals(input)) {
            String[] tokens = input.split(";");
            String cmd = tokens[1];

            Predicate<String> predicate = null;

            if (cmd.equals("Starts with")) {
                predicate = s -> s.startsWith(tokens[2]);
            } else if (cmd.equals("Ends with")) {
                predicate = s -> s.endsWith(tokens[2]);
            } else if (cmd.equals("Length")) {
                predicate = s -> s.length() == Integer.parseInt(tokens[2]);
            } else if (cmd.equals("Contains")) {
                predicate = s -> s.contains(tokens[2]);
            }

            String addRemove = tokens[0];

            if (addRemove.equals("Add filter")) {
                for (int i = 0; i < people.size(); i++) {
                    if (predicate.test(people.get(i))) {
                        removedPpl.add(people.remove(i));
                        i--;
                    }
                }
            } else {
                for (int i = 0; i < removedPpl.size(); i++) {
                    if (predicate.test(removedPpl.get(i))) {
                        people.add(0,removedPpl.remove(i));
                        i--;
                    }
                }
            }

            input = reader.readLine();
        }

        for (String person : people) {
            System.out.print(person+" ");
        }
    }
}
