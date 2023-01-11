package JavaExamsAdvanced.June25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class ChocolateTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Double> milks = new ArrayDeque<>();
        ArrayDeque<Double> cacaoPowder = new ArrayDeque<>();

        double[] mValues = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] cValues = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (int i = 0; i < mValues.length; i++) {
            milks.offer(mValues[i]);
        }

        for (int i = 0; i < cValues.length; i++) {
            cacaoPowder.push(cValues[i]);
        }

        Map<String, Integer> chocolates = new LinkedHashMap<>();
        chocolates.put("Baking Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Milk Chocolate", 0);

        while (!milks.isEmpty() && !cacaoPowder.isEmpty()) {
            double milk = milks.poll();
            double cacao = cacaoPowder.pop();

            double sum = milk + cacao;

            if (sum == cacao) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else if (sum / 2 == cacao) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            } else if (sum * 0.3 == cacao) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else {
                milk += 10;
                milks.offer(milk);
            }
        }

        Predicate<Map<String, Integer>> predicate = map -> {
            boolean everyType = true;
            for (Integer value : map.values()) {
                if (value < 1) {
                    everyType = false;
                }
            }
            return everyType;
        };

        if (predicate.test(chocolates)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> e : chocolates.entrySet()) {
            if (e.getValue() > 0) {
                System.out.println("# " + e.getKey() + " --> " + e.getValue());
            }
        }
    }
}
