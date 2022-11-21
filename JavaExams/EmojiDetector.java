package JavaExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(\\*\\*|::)(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        Pattern digits = Pattern.compile("\\d");
        Matcher digitMatcher = digits.matcher(input);

        BigInteger threshold = new BigInteger("1");

        while (digitMatcher.find()) {
            threshold = threshold.multiply(BigInteger.valueOf(Long.parseLong(digitMatcher.group())));
        }
        System.out.println("Cool threshold: " + threshold);

        List<String> coolEmojis = new ArrayList<>();
        int counter = 0;

        while (matcher.find()) {
            String word = matcher.group("emoji");
            BigInteger total = new BigInteger("0");
            for (int i = 0; i < word.length(); i++) {
                total = total.add(BigInteger.valueOf(word.charAt(i)));
            }

            if (total.compareTo(threshold) > 0) {
                coolEmojis.add(matcher.group());
            }

            counter++;
        }
        System.out.println(counter + " emojis found in the text. The cool ones are:");
        if (!coolEmojis.isEmpty()) {
            for (String coolEmoji : coolEmojis) {
                System.out.println(coolEmoji);
            }
        }
    }
}
