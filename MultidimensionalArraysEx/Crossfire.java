package MultidimensionalArraysEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        ArrayList<ArrayList<Integer>> field = new ArrayList<>();

        int counter = 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                numbers.add(counter++);
            }
            field.add(numbers);
        }

        String input = "";

        while (!"Nuke it from orbit".equals(input = sc.nextLine())) {
            int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            for (int i = col - radius; i <= col + radius; i++) {
                if (row >= 0 && row < field.size() && i >= 0 && i < field.get(row).size()) {
                    field.get(row).set(i, -1);
                }
            }

            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < field.size() && col >= 0 && col < field.get(i).size()) {
                    field.get(i).set(col, -1);
                }
            }

            for (ArrayList<Integer> integers : field) {
                removeNegativeInts(integers);
            }

            field.removeIf(ArrayList::isEmpty);
        }

        for (ArrayList<Integer> integers : field) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void removeNegativeInts(ArrayList<Integer> integers) {
        while (integers.contains(-1)) {
            integers.remove(integers.indexOf(-1));
        }
    }
}
