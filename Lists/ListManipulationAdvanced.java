package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String cmd = tokens[0];
            if ("Contains".equals(cmd)) {
                if (numbers.contains(Integer.parseInt(tokens[1]))) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if ("Get".equals(cmd)) {
                int sum = 0;
                for (Integer number : numbers) {
                    sum += number;
                }
                System.out.println(sum);
            } else if ("Filter".equals(cmd)) {
                String sign = tokens[1];
                int filter = Integer.parseInt(tokens[2]);
                if ("<".equals(sign)) {
                    for (Integer number : numbers) {
                        if (number < filter) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                } else if (">".equals(sign)) {
                    for (Integer number : numbers) {
                        if (number > filter) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                } else if (">=".equals(sign)) {
                    for (Integer number : numbers) {
                        if (number >= filter) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                } else if ("<=".equals(sign)) {
                    for (Integer number : numbers) {
                        if (number <= filter) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                }
            } else if ("Print".equals(cmd)) {
                if (tokens[1].equals("even")) {
                    for (Integer number : numbers) {
                        if (number % 2 == 0) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                } else {
                    for (Integer number : numbers) {
                        if (number % 2 == 1) {
                            System.out.print(number + " ");
                        }
                    }
                    System.out.println();
                }
            }
            input=sc.nextLine();
        }

    }
}
