package MultidimensionalArraysEx;

import java.util.Scanner;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = readMatrix(sc, rows, cols, "\\s+");

        int sum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int a = matrix[row][col];
                int b = matrix[row + 1][col];
                int c = matrix[row + 2][col];
                int d = matrix[row][col + 1];
                int e = matrix[row][col + 2];
                int f = matrix[row + 1][col + 1];
                int g = matrix[row + 1][col + 2];
                int h = matrix[row + 2][col + 1];
                int i = matrix[row + 2][col + 2];
                int totalSum = a + b + c + d + e + f + g + h + i;
                if (totalSum > sum) {
                    sum = totalSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println("Sum = " + sum);

        for (int i = bestRow; i <= bestRow + 2; i++) {
            for (int j = bestCol; j <= bestCol + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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
