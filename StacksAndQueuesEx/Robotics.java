package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Arrays;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] bot = sc.nextLine().split(";");
        int[] numbers = Arrays.stream(sc.nextLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int time = numbers[0] * 3600 + numbers[1] * 60 + numbers[2];

        String[] robotNames = new String[bot.length];
        int[] robotTimes = new int[bot.length];
        int[] currentTimes = new int[robotTimes.length];
        for (int i = 0; i < bot.length; i++) {
            String[] tokens = bot[i].split("-");
            robotNames[i] = tokens[0];
            robotTimes[i] = Integer.parseInt(tokens[1]);
            currentTimes[i] = 0;
        }

        String input = "";

        ArrayDeque<String> products = new ArrayDeque<>();

        while (!"End".equals(input = sc.nextLine())) {
            products.offer(input);
        }

        while (!products.isEmpty()) {

            numbers[2] += 1;

            for (int i = 0; i < robotNames.length; i++) {
                if (currentTimes[i] > 0) {
                    currentTimes[i]--;
                }
            }
            time++;

            String product = products.poll();

            boolean isTaken = false;
            for (int i = 0; i < robotNames.length; i++) {
                if (currentTimes[i] == 0) {
                    currentTimes[i] = robotTimes[i];
                    System.out.printf("%s - %s [%s]%n", robotNames[i], product
                            , getTime(time));
                    isTaken = true;
                    break;
                }
            }
            if (!isTaken) {
                products.offer(product);
            }
        }
    }

    private static String getTime(int time) {
        int hours = time / 3600 % 24;
        int minutes = time / 60 % 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
