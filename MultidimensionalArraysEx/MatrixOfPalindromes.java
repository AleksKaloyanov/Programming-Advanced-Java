package MultidimensionalArraysEx;

import java.util.Scanner;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[size[0]][size[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (char) (i + 97)+"";
                matrix[i][j] += (char) (i + j + 97);
                matrix[i][j] += (char) (i + 97);
            }
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string+ " ");
            }
            System.out.println();
        }
    }
}
