package ObjectsAndClassesEx.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, id, age);

            people.add(person);

            input = sc.nextLine();
        }

        people.sort(Comparator.comparingInt(Person::getAge));
        for (Person person : people) {
            System.out.print(person);
        }
    }
}
