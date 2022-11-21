package MultidimensionalArrays;

import java.util.Scanner;
import java.util.Arrays;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] size = readArray(sc, ". ");
        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(sc, rows, cols, ", ");

        int sumMax = Integer.MIN_VALUE;
        int rowMax = 0;
        int colMax = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int a = matrix[i][j];
                int b = matrix[i + 1][j];
                int c = matrix[i][j + 1];
                int d = matrix[i + 1][j + 1];
                if (a + b + c + d > sumMax) {
                    sumMax = a + b + c + d;
                    rowMax = i;
                    colMax = j;
                }
            }
        }
        System.out.println(matrix[rowMax][colMax] + " " + matrix[rowMax][colMax + 1]);
        System.out.println(matrix[rowMax + 1][colMax] + " " + matrix[rowMax + 1][colMax + 1]);
        System.out.println(sumMax);
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
