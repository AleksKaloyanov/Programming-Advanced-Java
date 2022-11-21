package Workshop;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int[] data;
    private int size;

    public SmartArray() {
        this.capacity = INITIAL_CAPACITY;
        this.data = new int[capacity];
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            grow();
        }
        this.data[size] = element;
        size++;
    }

    private void grow() {
        this.capacity *= 2;
        int[] newData = new int[this.capacity];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    public int get(int index) {
        ensureIndex(index);
        return this.data[index];
    }

    public int remove(int index) {
        ensureIndex(index);
        int removed = this.data[index];
        shift(index);

        this.size--;
        if (this.size <= this.capacity / 4) {
            Shrink();
        }
        return removed;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    private void Shrink() {
        this.capacity /= 2;
        int[] newData = new int[this.capacity];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    public int size() {
        return this.size;
    }

    private void ensureIndex(int index) {
        if (this.size <= index || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index out of bound");
        }
    }

    public void add(int index, int element) {
        ensureIndex(index);

        int last = this.data[size - 1];

        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }

        this.data[index] = element;
        this.add(last);
    }

    public boolean contains(int element) {
        return this.indexOf(element) != -1;
    }

    public int indexOf(int element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size(); i++) {
            consumer.accept(this.data[i]);
        }
    }
}
