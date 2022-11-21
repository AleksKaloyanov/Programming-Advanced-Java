package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        Deque<String> kids = new ArrayDeque<>();

        for (String s : input) {
            kids.offer(s);
        }

        int cycle = 1;

        while (kids.size() != 1) {
            for (int i = 1; i <= n; ++i) {
                if (cycle % 2 == 0 || cycle % 3 == 0 || cycle % 5 == 0 || cycle % 7 == 0 || cycle % 11 == 0) {
                    if (cycle == 3 || cycle == 5 || cycle == 7 || cycle == 11) {
                        if (n == i) {
                            System.out.println("Removed " + kids.poll());
                        } else {
                            kids.offer(kids.poll());
                        }
                    } else {
                        if (n == i) {
                            System.out.println("Prime " + kids.peek());
                            kids.offer(kids.poll());
                        } else {
                            kids.offer(kids.poll());
                        }
                    }
                } else {
                    if (n == i) {
                        System.out.println("Removed " + kids.poll());
                    } else {
                        kids.offer(kids.poll());
                    }
                }
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());
    }
}
