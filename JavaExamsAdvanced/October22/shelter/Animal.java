package JavaExamsAdvanced.October22.shelter;

public class Animal {
    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        setName(name);
        setAge(age);
        setCaretaker(caretaker);
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

    public String getCaretaker() {
        return caretaker;
    }

    private void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", getName(), getAge(), getCaretaker());
    }
}
