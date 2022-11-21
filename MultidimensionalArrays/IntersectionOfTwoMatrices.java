package MultidimensionalArrays;

import java.util.Scanner;
import java.util.Arrays;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        String[][] first = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            first[i] = getArray(sc);
        }

        String[][] second = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            second[i] = getArray(sc);
        }

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                if (first[i][j].equals(second[i][j])){
                    System.out.print(first[i][j]+" ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static String[] getArray(Scanner sc) {
        return sc.nextLine().split("\\s+");
    }
}
