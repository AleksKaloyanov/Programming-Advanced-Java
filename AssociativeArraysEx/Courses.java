package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Courses {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = "";

        while (!"end".equals(input = reader.readLine())) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);
        }

        courses.entrySet()
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().forEach(entry -> System.out.printf("-- %s%n", entry));
                });
    }
}
