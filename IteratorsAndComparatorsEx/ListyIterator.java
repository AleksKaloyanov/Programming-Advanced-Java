package IteratorsAndComparatorsEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int index;

    public ListyIterator(String... list) {
        setList(list);
        setIndex(0);
    }


    public boolean move() {
        if (this.index + 1 >= this.list.size()) {
            return false;
        }
        this.index++;
        return true;
    }

    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }

    public void print() {
        if (this.list.size() == 0) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.list.get(this.index));
        }
    }

    public List<String> getList() {
        return list;
    }

    private void setList(String... elements) {
        if (elements.length == 0) {
            this.list = new ArrayList<>();
        } else {
            this.list = Arrays.stream(elements).collect(Collectors.toList());
        }
    }

    public int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    public void printAll() {
        for (String s : this.list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator iterator() {
        return new Iterator<String>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return this.index + 1 < list.size();
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }
}
