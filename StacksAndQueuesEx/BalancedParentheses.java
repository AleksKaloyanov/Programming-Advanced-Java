package StacksAndQueuesEx;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Deque<Character> d = new ArrayDeque<>();

        String lookupTable = "([{";
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (lookupTable.contains(current+"")){
                d.push(current);
            }else {
                if (d.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char top = d.pop();
                if (!(top =='('&& current==')'||
                        top =='['&& current==']'||
                        top =='{'&& current=='}')){
                    isBalanced = false;
                    break;
                }
            }
        }
        String output = isBalanced ? "YES" : "NO";
        System.out.println(output);
    }
}
