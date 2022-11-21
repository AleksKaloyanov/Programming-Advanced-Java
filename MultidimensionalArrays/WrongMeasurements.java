package MultidimensionalArrays;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = readMatrix(sc, rows, "\\s+");

        int[] mistake = readArray(sc, "\\s+");
        int mistakeValue = matrix[mistake[0]][mistake[1]];
        int mistakeRow = mistake[0];
        int mistakeCol = mistake[1];

        int[][] resultMatrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            resultMatrix[i] = matrix[i].clone();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == mistakeValue) {
                    resultMatrix[i][j] = getSum(matrix, i, j, mistakeValue);
                }
            }
        }

        for (int[] ints : resultMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int row, int col, int value) {
        int sum = 0;

        if (row + 1 != matrix.length && matrix[row + 1][col] != value) {
            sum += matrix[row + 1][col];
        }
        if (row - 1 != -1 && matrix[row - 1][col] != value) {
            sum += matrix[row - 1][col];
        }
        if (col + 1 != matrix[row].length && matrix[row][col + 1] != value) {
            sum += matrix[row][col + 1];
        }
        if (col - 1 != -1 && matrix[row][col - 1] != value) {
            sum += matrix[row][col - 1];
        }

        return sum;
    }


    private static int[][] readMatrix(Scanner sc, int rows, String pattern) {
        int[][] matrix = new int[rows][];
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
