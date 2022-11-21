package DefiningClassesEx.Google;

public class Company {
    private String name;
    private String dept;
    private double salary;

    public Company(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getName(), this.getDept(), this.getSalary());
    }
}
