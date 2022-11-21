package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        List<String> validNames = new ArrayList<>();

        for (String s : input) {
            StringBuilder sb = new StringBuilder();
            String list = "-_";
            boolean isValid = true;
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                String st = String.valueOf(current);
                if (Character.isLetterOrDigit(current)) {
                    sb.append(current);
                } else if (list.contains(st)) {
                    sb.append(st);
                } else {
                    isValid = false;
                    break;
                }
            }
            if (sb.length() < 3 || sb.length() > 16) {
                isValid = false;
            }
            if (isValid) {
                validNames.add(sb.toString());
            }
        }
        for (String validName : validNames) {
            System.out.println(validName);
        }
    }
}
