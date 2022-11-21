package MidExam;

import java.util.Scanner;
import java.util.Arrays;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] houses = Arrays.stream(sc.nextLine().split("@"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = sc.nextLine();
        int currentIndex = 0;

        while (!input.equals("Love!")) {
            String[] tokens = input.split("\\s+");
            int length = Integer.parseInt(tokens[1]);
            int nextIndex = currentIndex + length;

            if (!valid(nextIndex, houses)) {
                nextIndex = 0;
            }

            currentIndex = nextIndex;

            if (houses[currentIndex] - 2 == 0) {
                houses[currentIndex] -= 2;
                System.out.printf("Place %d has Valentine's day.%n", currentIndex);
            } else if (houses[currentIndex] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }else {
                houses[currentIndex] -= 2;
            }

            input = sc.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);

        boolean isSuccessful = true;
        int counter = 0;

        for (int house : houses) {
            if (house != 0) {
                isSuccessful = false;
                counter++;
            }
        }

        if (isSuccessful) {
            System.out.println("Mission was successful.");
        }else {
            System.out.printf("Cupid has failed %d places.",counter);
        }
    }

    private static boolean valid(int nextIndex, int[] houses) {
        return nextIndex < houses.length;
    }
}
