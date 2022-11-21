package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> table = new LinkedHashMap<>();

        for (double number : numbers) {
            table.putIfAbsent(number, 0);
            table.put(number, table.get(number)+1);
        }

        table.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
