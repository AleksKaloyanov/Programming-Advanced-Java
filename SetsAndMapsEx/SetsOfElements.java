package SetsAndMapsEx;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        Set<Integer> a = new LinkedHashSet<>();
        Set<Integer> b = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(sc.nextLine()));
        }

        a.retainAll(b);

        for (Integer integer : a) {
            System.out.print(integer+" ");
        }
    }
}
