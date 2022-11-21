package MidExam;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int energy = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        int counter = 0;


        while (!input.equals("End of battle")) {
            String[] tokens = input.split("\\s+");
            int distance = Integer.parseInt(tokens[0]);
            if (energy - distance >= 0) {
                energy -= distance;
                counter++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", counter, energy);
                energy -= distance;
                break;
            }
            if (counter % 3 == 0) {
                energy += counter;
            }
            input = sc.nextLine();
        }
        if (energy >= 0) {
            System.out.printf("Won battles: %d. Energy left: %d", counter, energy);
        }
    }
}
