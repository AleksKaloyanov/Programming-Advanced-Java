package ListsEx;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int cap = Integer.parseInt(sc.nextLine());

        String input = sc.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            if (cmd.equals("Add")) {
                numbers.add(numbers.size(), Integer.parseInt(tokens[1]));
            } else {
                int p = Integer.parseInt(tokens[0]);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) + p <= cap) {
                        numbers.set(i, numbers.get(i) + p);
                        break;
                    }
                }
            }
            input = sc.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
