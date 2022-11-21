package MidExam;

import java.util.Scanner;
import java.util.Arrays;

public class ManOWar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(sc.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                    .toArray();

        int[] warShip = Arrays.stream(sc.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                    .toArray();

        int cap = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();

        boolean itsBroken = false;

        while (!input.equals("Retire")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            if ("Fire".equals(cmd)) {
                int index = Integer.parseInt(tokens[1]);
                int dmg = Integer.parseInt(tokens[2]);

                if (isValid(index, warShip)) {
                    warShip[index] -= dmg;

                    if (itBreaks(index, warShip)) {
                        System.out.println("You won! The enemy ship has sunken.");
                        itsBroken = true;
                        break;
                    }
                }
            } else if ("Defend".equals(cmd)) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                int dmg = Integer.parseInt(tokens[3]);

                if (isValid(startIndex, endIndex, pirateShip)) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= dmg;

                        if (itBreaks(i, pirateShip)) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            itsBroken = true;
                            break;
                        }
                    }
                }
            } else if ("Repair".equals(cmd)) {
                int index = Integer.parseInt(tokens[1]);
                int health = Integer.parseInt(tokens[2]);

                if (isValid(index, pirateShip)) {
                    pirateShip[index] += health;

                    if (health > cap) {
                        health = cap;
                    }
                }
            } else {
                int counter = 0;
                for (int i : pirateShip) {
                    int perc = cap / 5;

                    if (i < perc) {
                        counter++;
                    }
                }
                System.out.println(counter + " sections need repair.");
            }
            input = sc.nextLine();
        }
        if (!itsBroken) {
            int sumPirate = 0;
            int sumWar = 0;
            for (int i : warShip) {
                sumWar += i;
            }
            for (int i : pirateShip) {
                sumPirate += i;
            }
            System.out.println("Pirate ship status: "+sumPirate);
            System.out.println("Warship status: "+sumWar);
        }
    }

    private static boolean itBreaks(int index, int[] ship) {
        return ship[index] <= 0;
    }

    private static boolean isValid(int startIndex, int endIndex, int[] ship) {
        return startIndex >= 0 && startIndex < endIndex && endIndex < ship.length;
    }

    private static boolean isValid(int index, int[] ship) {
        return index >= 0 && index < ship.length;
    }
}
