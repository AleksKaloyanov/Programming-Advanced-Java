package MultidimensionalArraysEx;

import java.util.Scanner;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = readArray(sc, "\\s+");
        int rows = size[0];
        int cols = size[1];

        String[][] matrix = readMatrix(sc, rows, cols, "\\s+");

        String input = "";

        while (!"END".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");

            String cmd = tokens[0];

            if (cmd.equals("swap") && tokens.length == 5) {
                int index1 = Integer.parseInt(tokens[1]);
                int index2 = Integer.parseInt(tokens[2]);
                int index3 = Integer.parseInt(tokens[3]);
                int index4 = Integer.parseInt(tokens[4]);
                if (validIndex(rows, cols, index1, index2, index3, index4)) {
                    String temp = matrix[index1][index2];
                    matrix[index1][index2] = matrix[index3][index4];
                    matrix[index3][index4] = temp;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static boolean validIndex(int rows, int cols, int index1, int index2, int index3, int index4) {
        return index1 >= 0 && index1 < rows && index2 >= 0 && index2 < cols
                && index3 >= 0 && index3 < rows && index4 >= 0 && index4 < cols;
    }

    private static String[][] readMatrix(Scanner sc, int rows, int cols, String pattern) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = readArray(sc);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner sc, String pattern) {
        return Arrays.stream(sc.nextLine().split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String[] readArray(Scanner sc) {
        return sc.nextLine().split("\\s+");
    }
}
