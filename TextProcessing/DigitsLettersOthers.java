package TextProcessing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsLettersOthers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isLetter(current)){
                letters.append(current);
            } else if (Character.isDigit(current)) {
                digits.append(current);
            }else {
                others.append(current);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}
