package Lists;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("end")){
            String[] tokens = input.split(" ");
            String cmd = tokens[0];
            if (cmd.equals("Add")){
                numbers.add(numbers.size(),Integer.parseInt(tokens[1]));
            } else if (cmd.equals("Remove")) {
                numbers.remove(Integer.valueOf(Integer.parseInt(tokens[1])));
            } else if (cmd.equals("RemoveAt")) {
                numbers.remove(Integer.parseInt(tokens[1]));
            } else if (cmd.equals("Insert")) {
                int num = Integer.parseInt(tokens[1]);
                int index = Integer.parseInt(tokens[2]);
                numbers.add(index,num);
            }
            input = sc.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number+" ");
        }
    }
}
