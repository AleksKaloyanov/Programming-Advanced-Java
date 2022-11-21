package Generics.GenericSwapMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Box<T extends Comparable<T>> {
    private List<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void add(T element) {
        box.add(element);
    }

    public void swap(int index1, int index2) {
        if (checkIndexes(index1, index2)) {
            T var = this.box.get(index1);
            this.box.set(index1, this.box.get(index2));
            this.box.set(index2, var);
        }
    }

    private boolean checkIndexes(int index1, int index2) {
        return index1 >= 0 && (index1 < this.box.size() || index2 >= 0) && index2 < this.box.size();
    }

    public void forEach(Consumer<T> consumer) {
        for (T t : box) {
            consumer.accept(t);
        }
    }

    public int size() {
        return this.box.size();
    }

    public int compareTo(T element) {
        int counter = 0;
        for (int i = 0; i < this.size(); i++) {
            int result = box.get(i).compareTo(element);
            if (result > 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            stringBuilder.append(this.box.getClass().getName());
            stringBuilder.append(" ");
            stringBuilder.append(this.box.get(i));
            stringBuilder.append(System.lineSeparator());
        }
        return String.valueOf(stringBuilder);
    }
}
