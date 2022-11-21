package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = readArray(sc);
        int rows = size[0];
        int cols = size[1];

        int[][] first = new int[rows][cols];
        boolean areEqual = true;

        for (int i = 0; i < rows; i++) {
            first[i] = readArray(sc);
        }

        size = readArray(sc);
        rows = size[0];
        cols = size[1];

        int[][] second = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            second[i] = readArray(sc);
        }

        if (first.length != second.length) {
            areEqual = false;
        }

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                if (first[i].length != second[i].length) {
                    areEqual = false;
                    break;
                }
                if (first[i][j] != second[i][j]) {
                    areEqual = false;
                    break;
                }
            }
        }
        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static int[] readArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
