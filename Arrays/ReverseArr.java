package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] arr = input.split("\\s+");

        for (int i = arr.length-1; i >=0; i--) {
            System.out.print(arr[i]+" ");
        }
    }
}
