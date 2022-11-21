package SetsAndMapsEx;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Character,Integer> chars = new TreeMap<>();

        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            chars.putIfAbsent(c,0);
            chars.put(c,chars.get(c)+1);
        }

        chars.entrySet()
                .forEach(e->{
                    System.out.println(e.getKey()+": "+e.getValue()+" time/s");
                });
    }
}
