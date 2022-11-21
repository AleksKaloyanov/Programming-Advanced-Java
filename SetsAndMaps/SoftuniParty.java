package SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> peasants = new TreeSet<>();

        String input = "";

        while (!"PARTY".equals(input = sc.nextLine())) {
            char f = input.charAt(0);
            if (Character.isDigit(f)) {
                vip.add(input);
            } else {
                peasants.add(input);
            }
        }

        while (!"END".equals(input = sc.nextLine())) {
            if (vip.contains(input)) {
                vip.remove(input);
            } else {
                peasants.remove(input);
            }
        }

        System.out.println(vip.size() + peasants.size());
        for (String s : vip) {
            System.out.println(s);
        }
        for (String peasant : peasants) {
            System.out.println(peasant);
        }
    }
}
