package StacksAndQueuesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveFibonacci {
    public static long[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        f = new long[51];

        Arrays.fill(f, 0);

        f[0] = 1;
        f[1] = 1;

        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (f[n] != 0) {
            return f[n];
        }
        f[n] = (getFibonacci(n - 1) + getFibonacci(n - 2));
        return f[n];
    }
}
