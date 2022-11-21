package TextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextProcessing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] toReplace = reader.readLine().split(", ");

        String input = reader.readLine();

        for (String s : toReplace) {
            int length = s.length();
                input = input.replace(s, replacement(length));
        }
        System.out.println(input);
    }

    private static CharSequence replacement(int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(Math.max(0, length)));
        return sb;
    }
}
