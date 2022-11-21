package Methods;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String item = sc.nextLine();
        int quantity = Integer.parseInt(sc.nextLine());

        switch (item){
            case "coffee":
                System.out.println(calc(quantity, 1.50));
                break;
            case"water":
                System.out.println(calc(quantity,1));
                break;
        }
    }

    private static double calc(int quantity, double price) {
        return price*quantity;
    }
}
