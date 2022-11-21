package RegexEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        List<String> items = new ArrayList<>();
        double totalPrice = 0;


        while (!"Purchase".equals(input)) {
            Pattern pattern = Pattern.compile(">>(?<name>[A-Za-z]+)<<(?<price>\\d+(\\.\\d+)?)\\!(?<quantity>\\d+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;
                items.add(name);
            }
            input = reader.readLine();
        }

        System.out.println("Bought furniture:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
