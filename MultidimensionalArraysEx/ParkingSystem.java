package MultidimensionalArraysEx;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        String input = "";

        boolean[][] parking = new boolean[rows][cols];

        while (!"stop".equals(input = sc.nextLine())) {
            boolean wasParked = false;
            String[] tokens = input.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int desiredRow = Integer.parseInt(tokens[1]);
            int desiredCol = Integer.parseInt(tokens[2]);

            int distance = 0;

            if (rowHasEmptySpots(parking, desiredRow)) {
                int counter = 1;
                while (!isEmptySpot(parking, desiredRow, desiredCol)) {
                    int temp = desiredCol;
                    if (isEmptySpot(parking, desiredRow, temp - counter)) {
                        desiredCol -= counter;
                        break;
                    } else if (isEmptySpot(parking, desiredRow, temp + counter)) {
                        desiredCol += counter;
                        break;
                    }
                    counter++;
                }
                parking[desiredRow][desiredCol] = true;

                distance = +Math.abs(entryRow - desiredRow) + desiredCol+1;
                wasParked = true;
            }
            if (wasParked) {
                System.out.println(distance);
            }
            if (!rowHasEmptySpots(parking, desiredRow)) {
                System.out.println("Row " + desiredRow + " full");
                break;
            }
        }
    }

    private static boolean rowHasEmptySpots(boolean[][] parking, int desiredRow) {
        for (int i = 1; i < parking[desiredRow].length; i++) {
            if (!parking[desiredRow][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmptySpot(boolean[][] parking, int desiredRow, int desiredCol) {
        return !parking[desiredRow][desiredCol] && isValidSpot(parking, desiredRow, desiredCol);
    }

    private static boolean isValidSpot(boolean[][] parking, int desiredRow, int desiredCol) {
        return desiredRow >= 0 && desiredRow < parking.length && desiredCol >= 1 && desiredCol < parking.length;
    }
}
