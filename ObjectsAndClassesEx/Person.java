package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    public String name;
    public int age;

    public Person() {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d",name,age);
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person();

            person.setName(name);
            person.setAge(age);

            people.add(person);
        }

        for (Person person : people) {
            if (person.getAge() > 30) {
                System.out.println(person);
            }
        }
    }
}