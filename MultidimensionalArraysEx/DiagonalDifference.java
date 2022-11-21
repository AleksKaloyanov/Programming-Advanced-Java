package MultidimensionalArraysEx;

import java.util.Scanner;
import java.util.Arrays;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = readMatrix(sc, n, n, "\\s+");

        int sum1 = 0;
        int sum2 = 0;

        int row = 0;
        int col = 0;

        while (row < n && col < n) {
            sum1 += matrix[row++][col++];
        }

        row = n - 1;
        col = 0;

        while (row >= 0 && col < n) {
            sum2 += matrix[row--][col++];
        }

        System.out.println(Math.abs(sum1 - sum2));
    }

    private static int[][] readMatrix(Scanner sc, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = readArray(sc, pattern);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner sc, String pattern) {
        return Arrays.stream(sc.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
