package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceRepeatingChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder sb = new StringBuilder();

        char baseChar = input.charAt(0);
        sb.append(baseChar);

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (baseChar != currentChar) {
                sb.append(currentChar);
                baseChar = currentChar;
            }
        }
        System.out.println(sb);
    }
}
