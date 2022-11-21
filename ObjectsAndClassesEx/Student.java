package ObjectsAndClassesEx;

import java.util.*;

public class Student {
    public String firstName;
    public String lastName;
    public float grade;

    public Student(String firstName, String lastName, float grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", firstName, lastName, grade);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            float grade = Float.parseFloat(tokens[2]);

            Student student = new Student(firstName, lastName, grade);

            students.add(student);
        }
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
