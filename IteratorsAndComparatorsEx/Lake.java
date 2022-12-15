package IteratorsAndComparatorsEx;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < stones.length;
        }

        @Override
        public Integer next() {
            int stone = stones[index];
            index += 2;
            if (index >= stones.length && index % 2 == 0) {
                index = 1;
            }
            return stone;
        }
    }
}
