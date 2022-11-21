package MultidimensionalArrays;

import java.util.Scanner;
import java.util.Arrays;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        int[][] matrix = readMatrix(sc, size, size, "\\s+");

        int rows = 0;
        int cols = 0;

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[rows++][cols++] + " ");
        }

        rows = size - 1;
        cols = 0;

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[rows--][cols++] + " ");
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
