package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForceBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<String, List<String>> sides = new LinkedHashMap<>();

        while (!"Lumpawaroo".equals(input = reader.readLine())) {
            if (input.contains("|")) {
                String[] newCmd = input.split("\\s+\\|\\s+");
                String forceSide = newCmd[0];
                String forceUser = newCmd[1];
                sides.putIfAbsent(forceSide, new ArrayList<>());

                if (!contains(sides, forceUser)) {
                    sides.get(forceSide).add(forceUser);
                }
            } else {
                String[] newCmd = input.split("\\s+->\\s+");
                String forceUser = newCmd[0];
                String forceSide = newCmd[1];

                if (!contains(sides, forceUser)) {
                    sides.putIfAbsent(forceSide, new ArrayList<>());
                    sides.get(forceSide).add(forceUser);
                } else if (contains(sides, forceUser)) {
                    String currentSide = currentUserSide(sides, forceUser);
                    sides.get(currentSide).remove(forceUser);
                    sides.get(forceSide).add(forceUser);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
        }

        sides
                .entrySet()
                .stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue()
                            .forEach(u-> System.out.println("! "+u));
                });
    }

    private static String currentUserSide(Map<String, List<String>> sides, String forceUser) {
        for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
            if (entry.getValue().contains(forceUser)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static boolean contains(Map<String, List<String>> map, String user) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(user)) {
                return true;
            }
        }
        return false;
    }

}
