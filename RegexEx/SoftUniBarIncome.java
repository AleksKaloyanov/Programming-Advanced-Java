package RegexEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        double total = 0;

        while (!"end of shift".equals(input = reader.readLine())) {
            Pattern pattern = Pattern
                    .compile("%(?<name>[A-Z][a-z]+)%[^|%$.]*<(?<product>\\w+)>[^|%$.]*\\|(?<quantity>\\d+)\\|[^|%$.]*?(?<price>[\\d]+\\.?\\d*)\\$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                total += quantity * price;

                System.out.printf("%s: %s - %.2f%n", name, product, quantity * price);
            }
        }

        System.out.printf("Total income: %.2f%n", total);
    }
}
