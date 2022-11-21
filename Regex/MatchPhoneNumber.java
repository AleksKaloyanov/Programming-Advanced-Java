package Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("\\+359([\\ \\-])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);

        String separator = "";
        while (matcher.find()){
            System.out.print(separator+matcher.group());
            separator = ", ";
        }
    }
}
