package DataTypesAndVariablesEx;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int p = Integer.parseInt(sc.nextLine());

        int cnt = n/p;
        if (n % p != 0) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
