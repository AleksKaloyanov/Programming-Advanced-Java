package DataTypesAndVariablesEx;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int currentBestSnow = Integer.MIN_VALUE;
        int currentBestTime = Integer.MIN_VALUE;
        int currentBestQuality = Integer.MIN_VALUE;
        int currentBestValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(sc.nextLine());
            int time = Integer.parseInt(sc.nextLine());
            int quality = Integer.parseInt(sc.nextLine());

            int division = snow / time;
            double value = Math.pow(division, quality);

            if (value > currentBestValue) {
                currentBestValue = (int) value;
                currentBestQuality = quality;
                currentBestSnow = snow;
                currentBestTime = time;
            }
        }

        System.out.printf("%d : %d = %d (%d)", currentBestSnow,
                currentBestTime, currentBestValue, currentBestQuality);
    }
}
