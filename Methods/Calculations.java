package Methods;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cmd = sc.nextLine();
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        switch (cmd) {
            case "add":
                System.out.println(add(a, b));
                break;
            case"subtract":
                System.out.println(subtract(a,b));
        }
    }

    private static int subtract(int a, int b) {
        return a-b;
    }

    private static int add(int a, int b) {
        return a+b;
    }
}
