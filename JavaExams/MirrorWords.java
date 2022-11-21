package JavaExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(?<sep>@|#)(?<word>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> list = new ArrayList<>();
        int counter = 0;

        while (matcher.find()) {
            String word = matcher.group("word");
            String word2 = matcher.group("word2");
            String temp = "";

            for (int i = word.length() - 1; i >= 0; i--) {
                temp += word.charAt(i);
            }

            if (temp.equals(word2)) {
                list.add(word);
            }

            counter++;
        }

        if (counter == 0) {
            System.out.printf("No word pairs found!%n");
        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }

        if (list.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            String separator = "";
            for (String s : list) {
                System.out.printf("%s%s <=> %s", separator, s, new StringBuilder(s).reverse());
                separator = ", ";
            }
        }
    }
}
