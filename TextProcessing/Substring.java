package TextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String toRemove = reader.readLine();
        String input = reader.readLine();


        while (input.contains(toRemove)) {
            input = input.replace(toRemove, "");
        }
        System.out.println(input);
    }
}
