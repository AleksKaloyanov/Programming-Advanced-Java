package MidExam;

import java.util.*;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentCnt = Integer.parseInt(sc.nextLine());
        int lectures = Integer.parseInt(sc.nextLine());
        int bonus = Integer.parseInt(sc.nextLine());

        List<Integer> students = new ArrayList<>();

        for (int i = 0; i < studentCnt; i++) {
            int attendance = Integer.parseInt(sc.nextLine());
            students.add(i, attendance);
        }

        double totalBonusMax = 0;
        int studentWithMax = 0;

        for (Integer student : students) {
            double totalBonus = (student * 1.0 / lectures) * (5 + bonus);
            if (totalBonus > totalBonusMax) {
                totalBonusMax = Math.round(totalBonus);
                studentWithMax = student;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n",totalBonusMax);
        System.out.println("The student has attended " + studentWithMax + " lectures.");

    }
}
