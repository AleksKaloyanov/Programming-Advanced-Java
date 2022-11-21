package StacksAndQueuesEx;


import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> nums = new ArrayDeque<>();

        for (Integer num : numbers) {
            nums.push(num);
        }

        while (!nums.isEmpty()) {
            System.out.print(nums.pop()+" ");
        }
    }
}
