package DefiningClasses.BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            if (cmd.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
            } else if (cmd.equals("Deposit")) {
                int index = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(index)) {
                    double amount = Double.parseDouble(tokens[2]);
                    bankAccounts.get(index).deposit(amount);
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (cmd.equals("SetInterest")) {
                double rate = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(rate);
            } else {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                    int years = Integer.parseInt(tokens[2]);
                    System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(years));
                } else {
                    System.out.println("Account does not exist");
                }
            }
        }
    }
}
