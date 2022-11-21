package JavaExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretChat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder message = new StringBuilder(reader.readLine());

        String input = "";

        while (!"Reveal".equals(input = reader.readLine())) {
            String[] tokens = input.split(":\\|:");
            String cmd = tokens[0];
            if ("InsertSpace".equals(cmd)) {
                int index = Integer.parseInt(tokens[1]);
                message.insert(index, " ");
                System.out.println(message);
            } else if ("Reverse".equals(cmd)) {
                String toReverse = tokens[1];
                String temp = message.toString();
                if (temp.contains(toReverse)) {
                    temp = temp.replaceFirst(toReverse, "").concat(new StringBuilder(toReverse).reverse().toString());
                    message = new StringBuilder(temp);
                    System.out.println(message);
                }else {
                    System.out.println("error");
                }
            } else if ("ChangeAll".equals(cmd)) {
                String sub = tokens[1];
                String newS = tokens[2];
                String temp = message.toString();
                temp = temp.replace(sub, newS);
                message = new StringBuilder(temp);
                System.out.println(message);
            }
        }
        System.out.printf("You have a new text message: %s%n",message);
    }
}
