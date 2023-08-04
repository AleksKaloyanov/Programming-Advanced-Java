package LinkedLists;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        fillTheLL(ll);

        System.out.println("Please enter ExNum: ");
        int exNum = Integer.parseInt(sc.nextLine());

        switch (exNum) {
            case 1 -> {
                ll.traversalLL();
                removeDuplicates(ll);
                ll.traversalLL();
            }
            case 2 -> {
                Node k = returnNthToLastElement(ll, 2);
                Node i = nthToLast(ll, 2);
                System.out.println(k.value);
                System.out.println(i.value);
            }
            case 3 -> {
                ll.traversalLL();
                partition(ll, 5);
                ll.traversalLL();
            }
        }


    }

    private static LinkedList partition(LinkedList ll, int x) {
        Node currentNode = ll.head;
        ll.tail = ll.head;
        while (currentNode != null) {
            Node next = currentNode.next;
            if (currentNode.value < x) {
                currentNode.next = ll.head;
                ll.head = currentNode;
            } else {
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }
            currentNode = next;
        }
        ll.tail.next = null;
        return ll;
    }

    private static Node nthToLast(LinkedList ll, int i) {
        Node p1 = ll.head;
        Node p2 = ll.head;
        for (int j = 0; j < i; j++) {
            if (p2.next == null) return null;
            p2 = p2.next;

        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static Node returnNthToLastElement(LinkedList ll, int index) {
        int i = 0;
        Node cur = ll.head;
        while (ll.size - index != i) {
            i++;
            cur = cur.next;
        }

        return cur;
    }

    public static void removeDuplicates(LinkedList ll) {
        Node cur = ll.head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<>();
        while (cur != null) {
            if (!set.contains(cur.value)) {
                set.add(cur.value);
                prev = cur;
            } else {
                prev.next = cur.next;
                ll.size--;
            }
            cur = cur.next;
        }
    }

    private static void fillTheLL(LinkedList ll) {
        ll.createLL(1);
        ll.insertNode(2);
        ll.insertNode(1);
        ll.insertNode(8);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(10);
        ll.insertNode(4);
        ll.insertNode(3);
        ll.insertNode(5);
    }
}
