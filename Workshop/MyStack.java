package Workshop;

import java.util.function.Consumer;

public class MyStack {
    private Node top;
    private int size;

    class Node {
        private int element;
        private Node previous;

        public Node(int element) {
            this.element = element;
            this.previous = null;
        }
    }

    public MyStack() {
    }

    public void push(int element) {
        Node node = new Node(element);
        if (this.top != null) {
            node.previous = this.top;
        }
        this.top = node;
        size++;
    }

    public int peek() {
        return this.top.element;
    }

    public int pop() {
        int el = this.top.element;
        this.top = this.top.previous;
        size--;
        return el;
    }

    public int getSize() {
        return this.size;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.top;
        while (current != null) {
            consumer.accept(current.element);
            current = current.previous;
        }
    }
}
