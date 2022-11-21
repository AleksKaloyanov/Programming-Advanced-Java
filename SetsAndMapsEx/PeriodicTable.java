package SetsAndMapsEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Set<String> elements = new TreeSet<>();
        while (n-- > 0) {
            String input = sc.nextLine();
            String[] el = input.split("\\s+");
            elements.addAll(Arrays.asList(el));
        }

        for (String element : elements) {
            System.out.print(element+" ");
        }
    }
}
