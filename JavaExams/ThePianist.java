package JavaExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ThePianist {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, String>> pieces = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            pieces.putIfAbsent(piece, new HashMap<>());
            pieces.get(piece).put(composer, key);
        }

        String input = "";

        while (!"Stop".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");
            String cmd = tokens[0];
            String piece = tokens[1];
            if ("Add".equals(cmd)) {
                if (pieces.containsKey(piece)) {
                    System.out.printf("%s is already in the collection!%n", piece);
                } else {
                    String composer = tokens[2];
                    String key = tokens[3];
                    pieces.put(piece, new HashMap<>());
                    pieces.get(piece).put(composer, key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                }
            } else if ("Remove".equals(cmd)) {
                if (!pieces.containsKey(piece)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                } else {
                    pieces.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                }
            } else if ("ChangeKey".equals(cmd)) {
                if (!pieces.containsKey(piece)) {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                } else {
                    String newKey = tokens[2];
                    for (Map.Entry<String, String> entry : pieces.get(piece).entrySet()) {
                        String key = entry.getKey();
                        pieces.get(piece).put(key, newKey);
                    }
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                }
            }
        }

        pieces.forEach((key1, value1) -> {
            System.out.printf("%s -> Composer: ", key1);
            value1.forEach((key, value) -> System.out.printf("%s, Key: %s%n", key, value));
        });
    }
}
