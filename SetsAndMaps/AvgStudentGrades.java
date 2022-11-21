package SetsAndMaps;

import java.util.*;

public class AvgStudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }

        students.entrySet()
                .forEach(e -> {
                    System.out.printf("%s -> %s (avg: %.2f)%n", e.getKey(),
                            grade(e.getValue()),
                            e.getValue().stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average()
                                    .orElse(Double.parseDouble("0.00")));
                });
    }

    private static String grade(List<Double> students) {
        String output = "";
        String spl = "";
        for (Double student : students) {
            output += spl + String.format("%.2f", student);
            spl = " ";
        }
        return output;
    }
}
