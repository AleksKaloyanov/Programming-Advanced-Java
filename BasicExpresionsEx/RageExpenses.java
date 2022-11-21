package BasicExpresionsEx;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double headPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());

        int headCnt = n / 2;
        int mouseCnt = n / 3;
        int keyCnt = n / 6;
        int displayCnt = n / 12;

        double expenses = (headCnt * headPrice) + (mouseCnt * mousePrice) + (keyCnt * keyPrice) + (displayCnt * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.",expenses);
    }
}
