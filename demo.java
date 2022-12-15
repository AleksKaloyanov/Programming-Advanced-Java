import java.util.*;
import java.util.stream.Collectors;

public class demo {

    public static void main(String[] args) {
        Person theSetContractBreaker = new Person("Ivan", 22);

        List<Person> people = List.of(
                new Person("Ivan", 17),
                new Person("ivan", 17),
                new Person("Stoqn", 25),
                new Person("Ivan", 18),
                new Person("Ivan", 17),
                new Person("Stopn", 25),
                new Person("Stoqn", 25),
                theSetContractBreaker
        );

        Set<Person> treeSet = new TreeSet<>(people);
        Set<Person> hashSet = new HashSet<>(people);

        System.out.println(treeSet.size() + ": " + treeSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));
        System.out.println(hashSet.size() + ": " + hashSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));

//        Uncomment following lines of code to break set contract:
//        there will be 2 "Ivan 17" objects in each set

        System.out.println("Changing \"Ivan 22\" to \"Ivan 17\"");

        theSetContractBreaker.age = 17;

        System.out.println(treeSet.size() + ": " + treeSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));
        System.out.println(hashSet.size() + ": " + hashSet.stream()
                .map(Person::toString).collect(Collectors.joining(", ")));

    }

    private static final class Person implements Comparable<Person> {
        private final String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age;
        }

        @Override
        public boolean equals(Object o) {
//            return true; // all objects with the same hash are considered the same (in HashSet)
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
//            return 1; // All objects have the same hash (in HashSet)
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(Person person) {
//            return 0; // all objects are considered equal for ordering (in TreeSet)
            int cmp = name.compareTo(person.name);
            return cmp != 0
                    ? cmp
                    : Integer.compare(age, person.age);
        }
    }
}
