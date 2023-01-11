package JavaExamsFundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordReset {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String pass = reader.readLine();

        String input = "";

        while (!"Done".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            if (cmd.equals("TakeOdd")) {
                String temp = "";
                for (int i = 1; i < pass.length(); i += 2) {
                    temp += pass.charAt(i);
                }
                pass = temp;
                System.out.println(pass);
            } else if ("Cut".equals(cmd)) {
                int index = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);
                String sub = pass.substring(index, index + length);
                pass = pass.replaceFirst(sub, "");
                System.out.println(pass);
            } else if ("Substitute".equals(cmd)) {
                String substring = tokens[1];
                String substitute = tokens[2];
                if (pass.contains(substring)) {
                    pass = pass.replace(substring, substitute);
                    System.out.println(pass);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
        }
        System.out.println("Your password is: " + pass);
    }
}
