package Generics.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        CustomList<String> list = new CustomList<>();
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            Sorter.sort(list);

            if (cmd.equals("Add")) {
                list.add(tokens[1]);
            } else if (cmd.equals("Remove")) {
                list.remove(Integer.parseInt(tokens[1]));
            } else if (cmd.equals("Contains")) {
                System.out.println(list.contains(tokens[1]));
            } else if (cmd.equals("Swap")) {
                list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            } else if (cmd.equals("Greater")) {
                System.out.println(list.countGreaterThan(tokens[1]));
            } else if (cmd.equals("Max")) {
                System.out.println(list.getMax());
            } else if (cmd.equals("Min")) {
                System.out.println(list.getMin());
            } else if (cmd.equals("Print")) {
                list.forEach(System.out::println);
            }
        }
    }
}
