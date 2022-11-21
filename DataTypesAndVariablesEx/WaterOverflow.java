package DataTypesAndVariablesEx;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int cap = 255;
        int totalLitters = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(sc.nextLine());
            if (input <= cap) {
                totalLitters += input;
                cap -= input;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(totalLitters);
    }
}
