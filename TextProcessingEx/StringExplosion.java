package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();

        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '>') {
                sb.append(">");
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            } else if (power == 0) {
                sb.append(current);
            } else {
                power--;
            }
        }
        System.out.println(sb);
    }
}
