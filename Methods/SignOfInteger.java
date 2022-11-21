package Methods;

import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        whatIsTheSign(num);
    }

    private static void whatIsTheSign(int num) {
        if (num > 0) {
            System.out.printf("The number %d is positive.",num);
        }else if(num<0){
            System.out.printf("The number %d is negative.",num);
        }else {
            System.out.print("The number 0 is zero.");
        }
    }
}
