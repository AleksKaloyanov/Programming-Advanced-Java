package ArraysEx2;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] train = new int[n];

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(sc.nextLine());
            train[i] = p;
        }

        int sum = 0;

        for (int i : train) {
            System.out.print(i+" ");
            sum+=i;
        }
        System.out.println();
        System.out.println(sum);
    }
}
