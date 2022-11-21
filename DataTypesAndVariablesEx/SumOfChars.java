package DataTypesAndVariablesEx;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            String letter = sc.nextLine();
            char c = letter.charAt(0);
            sum+=c;
        }
        System.out.println("The sum equals: "+sum);
    }
}
