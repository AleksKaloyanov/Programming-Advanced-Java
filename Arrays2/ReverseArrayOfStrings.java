package Arrays2;

import java.util.Scanner;

public class ReverseArrayOfStrings  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("\\s+");

        for (int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i]+" ");
        }
    }
}
