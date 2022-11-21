package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = 8;

        String[][] matrix = readMatrix(sc, size, size, "\\s+");

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("q")) {
                    if (checkIfValid(matrix, row, col)) {
                        System.out.print(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean checkIfValid(String[][] matrix, int row, int col) {
        if (!checkURDiag(matrix, row-1, col+1)) {
            return false;
        }
        if (!checkULDiag(matrix, row-1, col-1)) {
            return false;
        }
        if (!checkDLDiag(matrix, row+1, col-1)) {
            return false;
        }
        if (!checkDRDiag(matrix, row+1, col+1)) {
            return false;
        }
        if (!checkUp(matrix, row-1, col)) {
            return false;
        }
        if (!checkDown(matrix, row+1, col)) {
            return false;
        }
        if (!checkLeft(matrix, row, col-1)) {
            return false;
        }
        if (!checkRight(matrix, row, col+1)) {
            return false;
        }
        return true;
    }

    private static boolean checkRight(String[][] matrix, int row, int col) {
        while (col < matrix.length) {
            if (matrix[row][col++].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLeft(String[][] matrix, int row, int col) {
        while (col > 0) {
            if (matrix[row][col--].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDown(String[][] matrix, int row, int col) {
        while (row < matrix.length) {
            if (matrix[row++][col].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkUp(String[][] matrix, int row, int col) {
        while (row > 0) {
            if (matrix[row--][col].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDLDiag(String[][] matrix, int row, int col) {
        while (row < matrix.length && col > 0) {
            if (matrix[row++][col--].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDRDiag(String[][] matrix, int row, int col) {
        while (row < matrix.length && col < matrix.length) {
            if (matrix[row++][col++].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkULDiag(String[][] matrix, int row, int col) {
        while (row > 0 && col > 0) {
            if (matrix[row--][col--].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkURDiag(String[][] matrix, int row, int col) {
        while (row > 0 && col < matrix.length) {
            if (matrix[row--][col++].equals("q")) {
                return false;
            }
        }
        return true;
    }

    private static String[][] readMatrix(Scanner sc, int rows, int cols, String pattern) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = readArray(sc, pattern);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static String[] readArray(Scanner sc, String pattern) {
        return sc.nextLine().split(pattern);
    }
}



