package JavaExamsAdvanced.October22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> caffeine = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> drinks = Arrays.stream(reader.readLine().trim().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int initial = 0;

        while (!caffeine.isEmpty() && !drinks.isEmpty()) {
            int caf = caffeine.remove(caffeine.size() - 1);
            int drink = drinks.remove(0);

            int total = caf * drink;

            if (initial + total <= 300) {
                initial += total;
            } else {
                drinks.add(drink);
                initial -= 30;
                if (initial < 0) {
                    initial = 0;
                }
            }
        }

        if (!drinks.isEmpty()) {
            System.out.print("Drinks left: ");
            String separator = "";
            for (Integer drink : drinks) {
                System.out.print(separator + drink);
                separator = ", ";
            }
            System.out.println();
            System.out.println("Stamat is going to sleep with " + initial + " mg caffeine.");
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.\n" +
                    "Stamat is going to sleep with " + initial + " mg caffeine.\n");
        }
    }
}
