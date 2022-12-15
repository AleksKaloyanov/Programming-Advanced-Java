package IteratorsAndComparatorsEx;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
//    private String town;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

//    public String getTown() {
//        return town;
//    }
//
//
//    @Override
//    public int compareTo(Person o) {
//        if (this.getName().compareTo(o.getName()) == 0) {
//            if (this.getAge() == o.getAge()) {
//                if (this.getTown().compareTo(o.getTown()) == 0) {
//                    return 1;
//                }
//            }
//        }
//        return 0;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return this.age == person.age && this.name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (31 * hash) + this.getAge() + this.getName().length();

        return hash;
    }

    @Override
    public int compareTo(Person o) {

        //check the names
        int cmp = this.getName().compareTo(o.getName());
//if the names are equal, check their ages;
        return cmp != 0 ? cmp : Integer.compare(this.getAge(), o.getAge());
    }
}
