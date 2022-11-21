package MidExam;

import java.util.Scanner;

public class SoftuniReception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int e1 = Integer.parseInt(sc.nextLine());
        int e2 = Integer.parseInt(sc.nextLine());
        int e3 = Integer.parseInt(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());

        int counter = 0;

        while (students > 0) {
            counter++;
            if (counter % 4 != 0) {
                students -= e1 + e2 + e3;
            }
        }
        System.out.println("Time needed: "+counter+"h.");
    }
}
