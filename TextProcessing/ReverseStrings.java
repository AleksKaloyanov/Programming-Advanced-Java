package TextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

        String input = "";

                while (!"end".equals(input = reader.readLine())){
                    StringBuilder toPrint = new StringBuilder(input);
                    System.out.println(input + " = " + toPrint.reverse());
                }
    }
}
