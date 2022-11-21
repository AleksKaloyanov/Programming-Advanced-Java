package TextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

        String[] words = reader.readLine().split(" ");

        StringBuilder print = new StringBuilder();

        for (String word : words) {
            print.append(word.repeat(word.length()));
        }
        System.out.println(print);
    }
}
