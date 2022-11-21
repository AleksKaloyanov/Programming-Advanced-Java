package ArraysEx;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String elements1 = sc.nextLine();
        String[] arr1 = elements1.split("\\s+");
        String elements2 = sc.nextLine();
        String[] arr2 = elements2.split("\\s+");

        for (String s : arr2) {
            for (String s1 : arr1) {
                if (s.equals(s1)){
                    System.out.print(s +" ");
                }
            }
        }
    }
}
