package ArraysEx2;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");

        for (String s2 : arr2) {
            for (String s1 : arr1) {
                if (s2.equals(s1)) System.out.print(s2 + " ");
            }
        }
    }
}
