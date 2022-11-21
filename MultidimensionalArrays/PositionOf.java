package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = getArray(sc);

        int rows = size[0];
        int cols = size[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = getArray(sc);
        }

        int number = Integer.parseInt(sc.nextLine());
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        System.out.println(isFound ? "": "not found");
    }

    private static int[] getArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
