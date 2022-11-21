package DataTypesAndVariablesEx;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());

        int start = n;
        int cnt = 0;

        while (n >= m) {
            if (n * 2 == start) {
                n /= y;
            }
            if (n - m >= 0) {
                n -= m;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(n);
        System.out.println(cnt);
    }
}
