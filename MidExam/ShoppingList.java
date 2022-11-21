package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = Arrays.stream(sc.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("Go Shopping!")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            String item = tokens[1];
            if (cmd.equals("Urgent")) {
                if (!list.contains(item)) {
                    list.add(0, item);
                }
            } else if (cmd.equals("Unnecessary")) {
                list.remove(item);
            } else if (cmd.equals("Correct")) {
                if (list.contains(item)) {
                    list.set(list.indexOf(item), tokens[2]);
                }
            } else {
                if (list.contains(item)) {
                    list.add(list.remove(list.indexOf(item)));
                }
            }
            input = sc.nextLine();
        }

        String separator = "";
        for (String s : list) {
            System.out.print(separator + s);
            separator = ", ";
        }
    }
}
