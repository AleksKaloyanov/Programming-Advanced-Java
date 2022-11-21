package RegexEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> racers = Arrays.stream(reader.readLine()
                        .split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> results = new LinkedHashMap<>();

        String input = "";

        while (!"end of race".equals(input = reader.readLine())) {
            Pattern letterPattern = Pattern.compile("[A-Z]|[a-z]");
            Matcher nameMatcher = letterPattern.matcher(input);
            StringBuilder name = new StringBuilder();

            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }

            if (racers.contains(name.toString())) {
                int distance = 0;
                Pattern digitPattern = Pattern.compile("\\d");
                Matcher digitMatcher = digitPattern.matcher(input);

                while (digitMatcher.find()) {
                    distance += Integer.parseInt(digitMatcher.group());
                }

                results.putIfAbsent(name.toString(), 0);
                results.put(name.toString(), results.get(name.toString()) + distance);
            }
        }
        int[] num = {1};
        results.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(3)
                .forEach(e -> {
                    switch (num[0]) {
                        case 1:
                            System.out.printf("1st place: %s%n", e.getKey());
                            break;
                        case 2:
                            System.out.printf("2nd place: %s%n", e.getKey());
                            break;
                        case 3:
                            System.out.printf("3rd place: %s%n", e.getKey());
                            break;
                    }
                    num[0]++;
                });
    }
}
