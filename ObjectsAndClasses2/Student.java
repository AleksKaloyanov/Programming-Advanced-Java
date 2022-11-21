package ObjectsAndClasses2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public Student() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String hometown = tokens[3];

            Student student = new Student();

            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAge(age);
            student.setHometown(hometown);

            if (!students.isEmpty()) {
                for (Student student1 : students) {
                    if (student1.getFirstName().equals(firstName) && student1.getLastName().equals(lastName)) {
                        student1.setAge(age);
                    } else {
                        students.add(student);
                    }
                    break;
                }
            } else {
                students.add(student);
            }

            input = sc.nextLine();
        }
        input = sc.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(input)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(),
                        student.getLastName(), student.getAge());
            }
        }

    }
}
