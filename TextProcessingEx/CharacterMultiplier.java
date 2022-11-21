package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    private static int calculateSum(String first, String second) {
        int sum = 0;
        int max = Math.max(first.length(), second.length());
        int min = Math.min(first.length(), second.length());

        for (int i = 0; i < max; i++) {
            if (i < min) {
                char c1 = first.charAt(i);
                char c2 = second.charAt(i);
                sum += c1 * c2;
            } else {
                if (first.length() == min) {
                    sum += second.charAt(i);
                }else {
                    sum+=first.charAt(i);
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        String first = input[0];
        String second = input[1];

        System.out.println(calculateSum(first, second));
    }
}