package Excercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, List<Integer>> heroes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            heroes.put(name, new ArrayList<>());
            heroes.get(name).add(hp);
            heroes.get(name).add(mp);
        }

        String input = "";

        while (!"End".equals(input = br.readLine())) {
            String[] tokens = input.split("\\s+-\\s+");
            String cmd = tokens[0];
            String name = tokens[1];
            switch (cmd) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(tokens[2]);
                    if (heroes.get(name).get(1) >= mpNeeded) {
                        heroes.get(name).set(1, heroes.get(name).get(1) - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, tokens[3],
                                heroes.get(name).get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, tokens[3]);
                    }
                    break;
                case "TakeDamage":
                    int dmg = Integer.parseInt(tokens[2]);
                    if (heroes.get(name).get(0) > dmg) {
                        heroes.get(name).set(0, heroes.get(name).get(0) - dmg);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                name, dmg, tokens[3], heroes.get(name).get(0));
                    } else {
                        System.out.printf("%s has been killed by %s!%n", name, tokens[3]);
                        heroes.remove(name);
                    }
                    break;
                case "Recharge":
                    int toRecharge = Integer.parseInt(tokens[2]);
                    int currentMP = heroes.get(name).get(1);
                    if (currentMP + toRecharge > 200) {
                        toRecharge = 200 - currentMP;
                    }
                    heroes.get(name).set(1, currentMP + toRecharge);
                    System.out.printf("%s recharged for %d MP!%n", name, toRecharge);
                    break;
                case "Heal":
                    int toHeal = Integer.parseInt(tokens[2]);
                    int currentHP = heroes.get(name).get(0);
                    if (currentHP + toHeal > 100) {
                        toHeal = 100 - currentHP;
                    }
                    heroes.get(name).set(0, currentHP + toHeal);
                    System.out.printf("%s healed for %d HP!%n", name, toHeal);
                    break;
            }
        }

        heroes.entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.printf("  HP: %d%n  MP: %d%n", e.getValue().get(0), e.getValue().get(1));
                });
    }
}
