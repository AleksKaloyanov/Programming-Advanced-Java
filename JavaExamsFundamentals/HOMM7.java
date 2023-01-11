package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HOMM7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            heroes.putIfAbsent(name, new ArrayList<>());
            heroes.get(name).add(hp);
            heroes.get(name).add(mp);
        }

        String input = "";

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+-\\s+");
            String cmd = tokens[0];
            String name = tokens[1];
            int currentHP = heroes.get(name).get(0);
            int currentMP = heroes.get(name).get(1);

            if ("CastSpell".equals(cmd)) {
                int mpNeeded = Integer.parseInt(tokens[2]);
                String spellName = tokens[3];

                if (currentMP >= mpNeeded) {
                    heroes.get(name).set(1, currentMP - mpNeeded);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName,
                            heroes.get(name).get(1));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                }
            } else if ("TakeDamage".equals(cmd)) {
                int dmg = Integer.parseInt(tokens[2]);
                String attacker = tokens[3];

                if (currentHP > dmg) {
                    heroes.get(name).set(0, currentHP - dmg);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, dmg, attacker,
                            heroes.get(name).get(0));
                } else {
                    heroes.remove(name);
                    System.out.printf("%s has been killed by %s!%n", name, attacker);
                }
            } else if ("Recharge".equals(cmd)) {
                int amount = Integer.parseInt(tokens[2]);

                if (amount + currentMP > 200) {
                    amount = 200 - currentMP;
                }

                heroes.get(name).set(1, currentMP + amount);
                System.out.printf("%s recharged for %d MP!%n", name, amount);
            } else if ("Heal".equals(cmd)) {
                int amount = Integer.parseInt(tokens[2]);

                if (amount + currentHP > 100) {
                    amount = 100 - currentHP;
                }

                heroes.get(name).set(0, currentHP + amount);
                System.out.printf("%s healed for %d HP!%n", name, amount);
            }
        }
        heroes.forEach((key, value) -> {
            System.out.println(key);
            System.out.printf("  HP: %d%n  MP: %d%n", value.get(0), value.get(1));
        });
    }
}
