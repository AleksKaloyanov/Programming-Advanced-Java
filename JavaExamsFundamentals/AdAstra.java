package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(?<separator>[#|\\|])(?<product>[A-Za-z ]+)\\1" +
                "(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]{0,4}|10000)\\1");
        Matcher matcher = pattern.matcher(input);

        Pattern calPattern = Pattern.compile("(?<separator>[#|\\|])(?<product>[A-Za-z ]+)\\1" +
                "(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]{0,4}|10000)\\1");
        Matcher calMatcher = calPattern.matcher(input);

        int totalCal = 0;

        while (calMatcher.find()) {
            totalCal += Integer.parseInt(calMatcher.group("cal"));
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCal / 2000);

        while (matcher.find()) {
            String item = matcher.group("product");
            String date = matcher.group("date");
            int cal = Integer.parseInt(matcher.group("cal"));
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", item, date, cal);
        }
    }
}
