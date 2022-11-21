package RegexEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, List<String>> stateOfPlanets = new LinkedHashMap<>();
        stateOfPlanets.put("Attacked planets", new ArrayList<>());
        stateOfPlanets.put("Destroyed planets", new ArrayList<>());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Pattern pattern = Pattern.compile("[STARstar]");
            Matcher matcher = pattern.matcher(input);
            int counter = 0;
            while (matcher.find()) {
                counter++;
            }
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char current = input.charAt(j);
                char newChar = (char) (current - counter);
                String newCh = String.valueOf(newChar);
                sb.append(newCh);
            }
            String decrypted = sb.toString();

            Pattern decPattern = Pattern.compile
                    ("[^@\\-!:>]*@(?<name>[A-Z][a-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*\\!(?<type>A|D)\\![^@\\-!:>]*->(?<soldiers>[\\d]+)[^@\\-!:>]*");
            Matcher decMatcher = decPattern.matcher(decrypted);

            if (decMatcher.find()) {
                String name = decMatcher.group("name");
                String type = decMatcher.group("type");

                switch (type) {
                    case "A" -> stateOfPlanets.get("Attacked planets").add(name);
                    case "D" -> stateOfPlanets.get("Destroyed planets").add(name);
                }
            }
        }

        stateOfPlanets.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value.size());
            value
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .forEach(p -> {
                        System.out.printf("-> %s%n", p);
                    });
        });
    }
}
