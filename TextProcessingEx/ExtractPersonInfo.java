package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractPersonInfo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String name = input.substring(input.indexOf("@")+1, input.indexOf("|"));
            String p = input.substring(input.indexOf("#")+1, input.indexOf("*"));
            int age = Integer.parseInt(p);

            System.out.printf("%s is %d years old.%n", name, age);
        }
    }
}
