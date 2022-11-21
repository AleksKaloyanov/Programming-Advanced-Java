package DataTypesAndVariablesEx;

import java.util.Scanner;

public class BeerKegs   {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String biggest = "";

        double currentBiggest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double radius = Double.parseDouble(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());

            double v = Math.pow(radius,2)*Math.PI * height;

            if (v > currentBiggest) {
                biggest = name;
                currentBiggest = v;
            }
        }
        System.out.println(biggest);
    }
}
