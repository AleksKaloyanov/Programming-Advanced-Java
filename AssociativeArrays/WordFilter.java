package AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(w -> w.length() % 2 == 0)
                .toArray(String[]::new);

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
