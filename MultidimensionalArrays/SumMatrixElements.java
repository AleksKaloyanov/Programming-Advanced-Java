package MultidimensionalArrays;

import java.util.Scanner;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = readArray(sc, ", ");
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(sc, rows, cols, ", ");

        System.out.println(rows);
        System.out.println(cols);

        int sum = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        System.out.println(sum);
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
