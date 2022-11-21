package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> nums = new ArrayDeque<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            if (input[0].equals("1")) {
                nums.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("2")) {
                nums.pop();
            } else if (input[0].equals("3")) {
                int max = Integer.MIN_VALUE;
                for (Integer num : nums) {
                    if (num > max) {
                        max = num;
                    }
                }
                System.out.println(max);
            }
        }
    }
}

