package BasicExpresionsEx;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double saberPrice = Double.parseDouble(sc.nextLine());
        double robePrice = Double.parseDouble(sc.nextLine());
        double beltPrice = Double.parseDouble(sc.nextLine());

        double saberCnt = Math.ceil(students *1.1);
        int beltCnt = students - (students/6);

        double totalPrice = (saberPrice*saberCnt)+(robePrice*students)+(beltCnt*beltPrice);

        if (totalPrice <= balance) {
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }else {
            double moneyNeeded = totalPrice - balance;
            System.out.printf("George Lucas will need %.2flv more.",moneyNeeded);
        }
    }
}
