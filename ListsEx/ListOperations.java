package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            if (cmd.equals("Add")) {
                numbers.add(numbers.size(), Integer.parseInt(tokens[1]));
            } else if (cmd.equals("Remove")) {
                if (numbers.size() > Integer.parseInt(tokens[1]) && Integer.parseInt(tokens[1]) >= 0) {
                    numbers.remove(Integer.parseInt(tokens[1]));
                } else {
                    System.out.println("Invalid index");
                }
            } else if (cmd.equals("Insert")) {
                int num = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                if (numbers.size() > index && index >= 0) {
                    numbers.add(index, num);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (tokens[1].equals("left")) {
                int cnt = Integer.parseInt(tokens[2]);
                for (int i = 0; i < cnt; i++) {
                    numbers.add(numbers.size() - 1, numbers.remove(0));
                }
            } else if (tokens[1].equals("right")) {
                int cnt = Integer.parseInt(tokens[2]);
                for (int i = 0; i < cnt; i++) {
                    numbers.add(0, numbers.remove(numbers.size() - 1));
                }
            }
            input = sc.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
