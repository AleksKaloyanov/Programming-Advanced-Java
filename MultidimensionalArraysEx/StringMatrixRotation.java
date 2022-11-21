package MultidimensionalArraysEx;

import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rotations = Integer.parseInt(sc.nextLine().split("[\\(\\)]")[1]);

        String input = "";
        String line = "";
        int maxLength = 0;

        while (!"END".equals(input = sc.nextLine())) {
            line += input;
            line += "\n";
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        rotations %= 360;

        String[] arr = line.split("\n");

        switch (rotations) {
            case 90:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = arr.length - 1; j >= 0; j--) {
                        try {
                            System.out.print(arr[j].charAt(i));
                        } catch (Exception e) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 180:
                System.out.println(new StringBuilder(line).reverse());
                break;
            case 270:
                for (int i = maxLength; i >= 0; i--) {
                    for (int j = 0; j < arr.length; j++) {
                        try {
                            System.out.print(arr[j].charAt(i));
                        } catch (Exception e) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 0:
                System.out.println(line);
                break;
        }
    }
}

