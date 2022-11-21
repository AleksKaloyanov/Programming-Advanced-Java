package Workshop;

import java.util.function.Consumer;

public class DoublyLinkedList {
    private class ListNode {
        private int element;
        private ListNode next;
        private ListNode previous;

        public ListNode(int element) {
            this.element = element;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public void addFirst(int element) {
        ListNode newHead = new ListNode(element);

        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }
        this.size++;
    }

    public void addLast(int element) {
        ListNode newTail = new ListNode(element);

        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            newTail.previous = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);

        if (index <= this.size / 2) {
            ListNode firstNode = this.head;
            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.element;
        } else {
            ListNode lastNode = this.tail;

            for (int i = this.size - 1; i > index; i--) {
                lastNode = lastNode.previous;
            }
            return lastNode.element;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size: " + this.size);

        }
    }

    public int removeFirst() {
        int el = this.head.element;
        this.head = this.head.next;
        this.head.previous = null;

        this.size--;
        return el;
    }

    public int removeLast() {
        int el = this.tail.element;
        this.tail = this.tail.previous;
        this.tail.next = null;

        this.size--;
        return el;
    }


    public void forEach(Consumer<Integer> consumer) {
        ListNode current = this.head;

        while (current != null) {
            consumer.accept(current.element);

            current = current.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        ListNode current = this.head;

        for (int i = 0; i < this.size; i++) {
            arr[i] = current.element;
            current = current.next;
        }

        return arr;
    }
}
