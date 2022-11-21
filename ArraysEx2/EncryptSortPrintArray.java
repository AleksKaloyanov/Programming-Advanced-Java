package ArraysEx2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }

        Integer[] encrypted = new Integer[n];

        for (int i = 0; i < names.length; i++) {
            String currentWord = names[i];
            int sum = 0;
            for (int j = 0; j < currentWord.length(); j++) {
                String table = "AaOoEeIiUu";
                String currentCh = currentWord.charAt(j) + "";
                if (table.contains(currentCh)) {
                    sum += currentWord.charAt(j) * currentWord.length();
                } else {
                    sum += currentWord.charAt(j) / currentWord.length();
                }
            }
            encrypted[i] = sum;
        }
        Arrays.sort(encrypted);
        for (Integer integer : encrypted) {
            System.out.println(integer);
        }
    }
}
