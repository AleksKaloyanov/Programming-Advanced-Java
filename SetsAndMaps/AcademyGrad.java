package SetsAndMaps;

import java.util.*;

public class AcademyGrad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Double> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            students.putIfAbsent(name, 0.0);
            double avg = 0;
            for (double number : numbers) {
                avg += number;
            }
            avg /= numbers.length;
            students.put(name, avg);
        }

        for (Map.Entry<String, Double> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " is graduated with " + entry.getValue());
        }
    }
}
