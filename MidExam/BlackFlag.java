package MidExam;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        int plunderPerDay = Integer.parseInt(sc.nextLine());
        int expected = Integer.parseInt(sc.nextLine());

        double sum = 0;

        for (int i = 1; i <= days; i++) {
            sum+=plunderPerDay;
            if (i % 3 == 0) {
                sum += plunderPerDay*0.5;
            }
            if (i % 5 == 0) {
                sum*=0.7;
            }
        }

        if (sum >= expected) {
            System.out.printf("Ahoy! %.2f plunder gained.",sum);
        }else {
            double percentage = (sum/expected)*100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentage);
        }
    }
}
