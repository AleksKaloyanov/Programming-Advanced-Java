package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ASCIIsumator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

        String firstChar = reader.readLine();
        String secondChar = reader.readLine();

        String input = reader.readLine();

        char first = firstChar.charAt(0);
        char second = secondChar.charAt(0);

        int max = Math.max(first,second);
        int min = Math.min(first,second);

        int sum =0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current > min && current < max) {
                sum+=current;
            }
        }
        System.out.println(sum);
    }
}
