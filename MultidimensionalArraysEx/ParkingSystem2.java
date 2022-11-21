package MultidimensionalArraysEx;

import java.util.Scanner;
import java.util.Arrays;

public class ParkingSystem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] size = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[][] parking = new boolean[size[0]][size[1]];

        String input = "";

        while (!"stop".equals(input = sc.nextLine())) {
            String[] tokens = input.split("\\s+");
            int entry = Integer.parseInt(tokens[0]);
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            int moves = 0;
            boolean isFound = false;

            if (!parking[row][col]) {
                parking[row][col] = true;
                moves = findMoves(entry, row, col);
                isFound = true;
            } else {
                while (!isFound) {
                    int range = 1;
                    if (col - range >= 1 && !parking[row][col - range]) {
                        moves = findMoves(entry, row, col - range);
                        isFound = true;
                        parking[row][col - range] = true;
                        break;
                    } else if (col + range < parking[row].length && !parking[row][col + range]) {
                        moves = findMoves(entry, row, col + range);
                        isFound = true;
                        parking[row][col + range] = true;
                        break;
                    }
                    if (col - range < 1 && col + range >= parking.length) {
                        System.out.println("Row " + row + " full");
                        break;
                    }
                    range++;
                }
            }
            if (isFound) {
                System.out.println(moves);
            }
        }
    }

    private static int findMoves(int entry, int row, int col) {
        return Math.abs(entry - row) + col + 1;
    }
}
