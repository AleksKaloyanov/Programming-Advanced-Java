package WorkingWithAbstraction.SystemStudent;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return this.studentsByName;
    }

    public void ParseCommand(String[] args) {
        String cmd = args[0];
        if (cmd.equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            Student student = new Student(name, age, grade);
            studentsByName.putIfAbsent(name, student);
        } else if (cmd.equals("Show")) {
            String name = args[1];

            Student student = studentsByName.get(name);

            student.toString();
        }
    }
}
