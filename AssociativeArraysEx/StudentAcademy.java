package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            double grade = Double.parseDouble(reader.readLine());

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students
                .entrySet()
                .stream()
                .filter(s -> s.getValue()
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .getAsDouble() >= 4.50)
                .forEach(e -> System.out.println(String.format("%s -> %.2f",
                        e.getKey(), e.getValue()
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .getAsDouble())));

    }
}
