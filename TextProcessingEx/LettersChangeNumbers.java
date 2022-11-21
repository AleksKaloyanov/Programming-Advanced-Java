package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        double sum = 0.0;

        for (String s : input) {
            StringBuilder number = new StringBuilder();
            for (int i = 1; i < s.length() - 1; i++) {
                number.append(String.valueOf(s.charAt(i)));
            }
            int n = Integer.parseInt(String.valueOf(number));
            char firstLetter = s.charAt(0);
            char lastLetter = s.charAt(s.length() - 1);

            if (Character.isLowerCase(firstLetter)) {
                sum += n * 1.0 * (firstLetter - 96);
            } else {
                sum += n * 1.0 / (firstLetter - 64);
            }
            if (Character.isLowerCase(lastLetter)) {
                sum += lastLetter - 96;
            } else {
                sum -= lastLetter - 64;
            }
        }
        System.out.printf("%.2f%n", sum);
    }
}
