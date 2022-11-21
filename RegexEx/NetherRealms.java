package RegexEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Double>> demonsStats = new HashMap<>();
        String[] demons = reader.readLine().split(",\\s+");

        Pattern health = Pattern.compile("[^\\d\\+\\-\\*\\/\\.]");
        Pattern dmgPat = Pattern.compile("[+-]?[0-9]+\\.?\\d*");

        for (String demon : demons) {
            Matcher hpMat = health.matcher(demon);
            Matcher dmgMat = dmgPat.matcher(demon);

            double hp = 0;
            while (hpMat.find()) {
                hp += hpMat.group().charAt(0);
            }

            double dmg = 0.0;
            while (dmgMat.find()) {
                dmg = dmg + Double.parseDouble(dmgMat.group());
            }

            for (int i = 0; i < demon.length(); i++) {
                char current = demon.charAt(i);

                if (current == '*') {
                    dmg *= 2;
                }
                if (current == '/') {
                    dmg /= 2;
                }
            }
            demonsStats.putIfAbsent(demon, new ArrayList<>());
            demonsStats.get(demon).add(hp);
            demonsStats.get(demon).add(dmg);
        }

        demonsStats
                .entrySet()
                .stream()
//                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.printf("%s - %.0f health, %.2f damage%n", e.getKey(), e.getValue().get(0), e.getValue().get(1));
                });
    }
}
