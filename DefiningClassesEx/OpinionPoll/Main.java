package DefiningClassesEx.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<People> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            People person = new People(name, age);
            people.add(person);
        }

        people.stream()
                .filter(people1 -> people1.getAge() > 30)
                .sorted((people1, people2) -> people1.getName().compareTo(people2.getName()))
                .forEach(people1 -> System.out.printf("%s - %d%n", people1.getName(), people1.getAge()));
    }
}
