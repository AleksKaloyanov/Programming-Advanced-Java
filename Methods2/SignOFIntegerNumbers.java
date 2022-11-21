package Methods2;

import java.util.Scanner;

public class SignOFIntegerNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        checkSign(n);
    }

    private static void checkSign(int n) {
        if (n>=0) {
            System.out.print("+");
        }else {
            System.out.println("-");
        }
    }
}
