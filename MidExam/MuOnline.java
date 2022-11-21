package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> dungeon = Arrays.stream(sc.nextLine().split("\\|"))
                .collect(Collectors.toList());

        int health = 100;
        int bitcoins = 0;

        int counter = 1;

        while (!dungeon.isEmpty()) {
            String[] room = dungeon.remove(0).split("\\s+");
            String cmd = room[0];
            int value = Integer.parseInt(room[1]);

            if (cmd.equals("potion")) {
                if (health + value > 100) {
                    System.out.printf("You healed for %d hp.%n", 100 - health);
                    health = 100;
                } else {
                    System.out.printf("You healed for %d hp.%n", value);
                    health += value;
                }
                System.out.println("Current health: "+health+" hp.");
            } else if (cmd.equals("chest")) {
                bitcoins += value;
                System.out.println("You found " + value + " bitcoins.");
            } else {
                health -= value;
                if (health <= 0) {
                    System.out.printf("You died! Killed by %s.%n", cmd);
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", cmd);
                }
            }
            counter++;
        }
        if (health <= 0) {
            System.out.println("Best room: " + counter);
        } else {
            System.out.printf("You've made it!%n" +
                    "Bitcoins: %d%n" +
                    "Health: %d%n", bitcoins, health);
        }
    }
}
