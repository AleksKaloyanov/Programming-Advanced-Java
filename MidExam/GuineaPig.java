package MidExam;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double food = Double.parseDouble(sc.nextLine());
        double hay = Double.parseDouble(sc.nextLine());
        double cover = Double.parseDouble(sc.nextLine());
        double weight = Double.parseDouble(sc.nextLine());

        int counter = 0;

        double foodInG = food * 1000;
        double hayInG = hay * 1000;
        double coverInG = cover * 1000;
        double weightInG = weight * 1000;

        while (counter++ < 30) {
            foodInG -= 300;
            if (counter % 2 == 0) {
                hayInG -= foodInG * 0.05;
            }
            if (counter % 3 == 0) {
                coverInG -= weightInG / 3;
            }
            if (noMoreLeft(foodInG, hayInG, coverInG)) {
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }

        food = foodInG / 1000;
        cover = coverInG / 1000;
        hay = hayInG / 1000;

        if (!noMoreLeft(food, hay, cover)) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", food, hay, cover);
        }
    }

    private static boolean noMoreLeft(double food, double hay, double cover) {
        return food <= 0 || hay <= 0 || cover <= 0;
    }
}
