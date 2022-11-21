package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int pop = input[1];
        int con = input[2];

        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            nums.offer(sc.nextInt());
        }

        for (int i = 0; i < pop; i++) {
            nums.poll();
        }
        if (nums.isEmpty()) {
            System.out.println(0);
        } else {
            if (nums.contains(con)) {
                System.out.println("true");
            } else {
                int max = Integer.MAX_VALUE;
                for (Integer num : nums) {
                    if (num < max) {
                        max = num;
                    }
                }
                System.out.println(max);
            }
        }
    }
}
