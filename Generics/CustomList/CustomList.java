package Generics.CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;
    private int size;

    public CustomList() {
        this.list = new ArrayList<>();
        this.size = 0;
    }

    public void add(T element) {
        this.list.add(element);
        this.size++;
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public T remove(int index) {
        checkIndex(index);
        this.size--;
        return this.list.remove(index);
    }

    public int size() {
        return this.size;
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int index1, int index2) {
        checkIndex(index1);
        checkIndex(index2);
        T var = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, var);

    }

    public int countGreaterThan(T element) {
        int counter = 0;

        for (T t : list) {
            int i = t.compareTo(element);
            if (i > 0) {
                counter++;
            }
        }

        return counter;
    }

    public T getMax() {
        if (!this.list.isEmpty()) {
            return this.list.stream().max(T::compareTo).get();
        }
        return null;
    }

    public T getMin() {
        if (!this.list.isEmpty()) {
            return this.list.stream().min(T::compareTo).get();
        }
        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("outOfBounds");
        }
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
