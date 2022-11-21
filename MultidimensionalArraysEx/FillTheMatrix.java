package MultidimensionalArraysEx;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];
        int counter = 1;

        if (pattern.equals("A")) {
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[col][row] = counter++;
                }
            }
        } else if (pattern.equals("B")) {
            for (int row = 0; row < size; row++) {
                if (row % 2 == 0) {
                    for (int col = 0; col < size; col++) {
                        matrix[col][row] = counter++;
                    }
                } else {
                    for (int col = size - 1; col >= 0; col--) {
                        matrix[col][row] = counter++;
                    }
                }
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
