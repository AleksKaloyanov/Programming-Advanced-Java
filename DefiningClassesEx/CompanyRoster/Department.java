package DefiningClassesEx.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    private int counter = 0;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(counter++, employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
