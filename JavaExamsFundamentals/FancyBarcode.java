package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Pattern pattern = Pattern.compile("@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
            Matcher matcher = pattern.matcher(input);

            String group = "";

            if (matcher.find()) {
                String product = matcher.group("product");

                for (int j = 0; j < product.length(); j++) {
                    char current = product.charAt(j);
                    Pattern digit = Pattern.compile("[0-9]");
                    Matcher digitMatcher = digit.matcher(current + "");
                    if (digitMatcher.find()) {
                        group += current + "";
                    }
                }
                if (group.isEmpty()) {
                    group = "00";
                }
                System.out.printf("Product group: %s%n", group);
            }else {
                System.out.println("Invalid barcode");
            }
        }
    }
}