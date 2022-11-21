package BasicExpresions;

import java.util.Scanner;

public class BackIn30Mins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        if (m + 30 >= 60) {
            m -= 30;
            h++;
            if (h == 24) {
                h = 0;
            }
        } else {
            m += 30;
        }

        if (m < 10) {
            System.out.printf("%d:%02d", h, m);
        } else {
            System.out.println(h + ":" + m);
        }
    }
}