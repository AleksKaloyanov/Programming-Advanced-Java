package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Plants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int c = 1;
        int days = 0;

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        while (c != 0) {
            c = 0;
            for (int i = 1; i < numbers.size(); i++) {
                int previous = numbers.get(i - 1);
                int current = numbers.get(i);

                if (previous < current) {
                    indexes.offer(i);
                    c++;
                }
            }
            if (indexes.isEmpty()) {
                break;
            }
            for (Integer index : indexes) {
                numbers.set(index, 0);
            }

            indexes.clear();
            numbers.removeIf(number -> number == 0);
            days++;
        }
        System.out.println(days);
    }
}
