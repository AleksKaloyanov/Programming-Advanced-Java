package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(?<sep>\\=|\\/)(?<des>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();
        int points = 0;

        while (matcher.find()) {
            destinations.add(matcher.group("des"));
            points += matcher.group("des").length();
        }

        System.out.print("Destinations: ");
        String sep = "";
        for (String destination : destinations) {
            System.out.print(sep + destination);
            sep = ", ";
        }
        System.out.println();
        System.out.printf("Travel Points: %d%n", points);
    }
}
