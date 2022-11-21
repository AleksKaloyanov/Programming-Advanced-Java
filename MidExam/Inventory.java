package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> inventory = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String cmd = tokens[0];
            String item = tokens[1];

            if (cmd.equals("Collect")) {
                if (!inventory.contains(item)) {
                    inventory.add(item);
                }
            } else if (cmd.equals("Drop")) {
                inventory.remove(item);
            } else if (cmd.equals("Renew")) {
                if (inventory.contains(item)) {
                    inventory.add(inventory.remove(inventory.indexOf(item)));
                }
            } else {
                String[] items = item.split(":");
                if (inventory.contains(items[0])) {
                    inventory.add(inventory.indexOf(items[0]) + 1, items[1]);
                }
            }
            input = sc.nextLine();
        }

        String separator = "";

        for (String s : inventory) {
            System.out.print(separator + s);
            separator = ", ";
        }
    }
}
