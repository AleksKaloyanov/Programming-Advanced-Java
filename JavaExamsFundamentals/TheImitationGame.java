package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheImitationGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder word = new StringBuilder(reader.readLine());
        String input = "";

        while (!"Decode".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");
            String cmd = tokens[0];
            if ("Move".equals(cmd)) {
                int counter = Integer.parseInt(tokens[1]);
                for (int i = 0; i < counter; i++) {
                    char c = word.charAt(0);
                    word.deleteCharAt(0);
                    word.append(c);
                }
            } else if ("Insert".equals(cmd)) {
                int index = Integer.parseInt(tokens[1]);
                String ch = tokens[2];
                word.insert(index, ch);
            } else if ("ChangeAll".equals(cmd)) {
                String newWord = word.toString();
                newWord = newWord.replace(tokens[1], tokens[2]);
                word = new StringBuilder(newWord);
            }
        }
        System.out.printf("The decrypted message is: %s%n", word);
    }
}
