package DataTypesAndVariablesEx;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = Integer.parseInt(sc.nextLine());
        int n2 = Integer.parseInt(sc.nextLine());
        int n3 = Integer.parseInt(sc.nextLine());
        int n4 = Integer.parseInt(sc.nextLine());

        int sum = (n1 + n2) / n3 * n4;
        System.out.println(sum);
    }
}
