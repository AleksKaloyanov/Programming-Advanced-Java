package IteratorsAndComparatorsEx;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {
    private Integer[] elements;
    private int currentIndex;

    public CustomStack() {
        this.elements=new Integer[16];
        this.currentIndex=0;
    }

    public void Push(Integer... elements) {
        for (Integer element : elements) {
            this.elements[this.currentIndex++] = element;
        }
    }

    public void Pop() {
        if (this.currentIndex > 0) {
            this.elements[this.currentIndex--] = null;
        } else {
            System.out.println("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = currentIndex;

            @Override
            public boolean hasNext() {
                return this.index - 1 >= 0;
            }

            @Override
            public Integer next() {
                return elements[--this.index];
            }
        };
    }
}
