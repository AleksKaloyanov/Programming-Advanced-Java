package Workshop;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        for (int i = 1; i <= 8; i++) {
            smartArray.add(i);
        }

        smartArray.add(0, 13);
        System.out.println();


        MyStack stack = new MyStack();

        stack.push(3);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);

        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(4));

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());

        System.out.println("-----------------------");

        linkedList.forEach(System.out::println);

        int[] ints = linkedList.toArray();

        System.out.println();
    }
}
