package IteratorsAndComparatorsEx;

public class Pet {
    private String name;
    private int age;
    private String kind;


    public Pet(String name, int age, String kind) {
        setName(name);
        setAge(age);
        setKind(kind);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    private void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.kind;
    }
}
