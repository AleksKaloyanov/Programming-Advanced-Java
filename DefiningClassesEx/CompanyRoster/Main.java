package DefiningClassesEx.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Department> departments = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentName = tokens[3];

            Employee employee = new Employee(name, salary, position, departmentName);

            if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee.setEmail(email);
                employee.setAge(age);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    String email = tokens[4];
                    employee.setEmail(email);
                } else {
                    int age = Integer.parseInt(tokens[4]);
                    employee.setAge(age);
                }
            }

            boolean found = false;

            for (Department department : departments) {
                if (department.getName().equals(departmentName)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                Department department = new Department(departmentName);
                departments.add(department);
            }
            for (Department department1 : departments) {
                if (department1.getName().equals(departmentName)) {
                    department1.addEmployee(employee);
                }
            }

        }

        String currentBest = "";
        double totalBest = 0;
        for (Department department : departments) {
            double total = 0;
            int counter = 0;
            for (Employee employee : department.getEmployees()) {
                total += employee.getSalary();
                counter++;
            }
            total /= counter;
            if (totalBest < total) {
                totalBest = total;
                currentBest = department.getName();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", currentBest);
        for (Department department : departments) {
            if (department.getName().equals(currentBest)) {
                department.getEmployees().stream()
                        .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                        .forEach(employee -> {
                            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary()
                                    , employee.getEmail(), employee.getAge());
                        });
            }
        }
    }
}
