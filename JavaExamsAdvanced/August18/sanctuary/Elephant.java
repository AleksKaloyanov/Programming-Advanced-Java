package JavaExamsAdvanced.August18.sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        setName(name);
        setAge(age);
        setRetiredFrom(retiredFrom);
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", this.getName(), this.getAge(), this.getRetiredFrom());
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

    public String getRetiredFrom() {
        return retiredFrom;
    }

    private void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }
}
