package BasicExpresionsEx;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();

        StringBuilder password = new StringBuilder();
        char ch;

        for (int i = 0; i < username.length(); i++) {
            ch = username.charAt(i);
            password.insert(0, ch);
        }

        int counter = 0;
        boolean blocked = false;
        String cmd = sc.nextLine();

        while (!cmd.equals(password.toString())) {
            counter++;

            if (counter == 4) {
                blocked = true;
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }

            cmd = sc.nextLine();
        }

        if (blocked) {
            System.out.printf("User %s blocked!", username);
        } else {
            System.out.printf("User %s logged in.", username);
        }
    }
}
