package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split(", ");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            people.add(person);
        }

        Map<String, Predicate<Person>> predicateMap = new HashMap<>();

        String yearCondition = reader.readLine();

        int age = Integer.parseInt(reader.readLine());

        predicateMap.put("younger", p -> p.age <= age);
        predicateMap.put("older", p -> p.age >= age);

        Map<String, Consumer<Person>> consumerMap = new HashMap<>();

        consumerMap.put("name", p -> System.out.println(p.name));
        consumerMap.put("age", p -> System.out.println(p.age));
        consumerMap.put("name age", p -> System.out.println(p.name + " - " + p.age));

        String printCondition = reader.readLine();

        people.stream()
                .filter(predicateMap.get(yearCondition))
                .forEach(consumerMap.get(printCondition));
    }
}
