package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeaserCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char n = (char) (c+3);

            sb.append(String.valueOf(n));
        }
        System.out.println(sb);
    }
}
