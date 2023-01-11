package JavaExamsAdvanced.October22.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;

    private int capacity;

    public Shelter(int capacity) {
        this.data = new ArrayList<>();
        setCapacity(capacity);
    }

    public List<Animal> getData() {
        return data;
    }

    private void setData(List<Animal> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Animal animal) {
        if (this.data.size() < capacity) {
            this.data.add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal datum : this.data) {
            if (datum.getName().equals(name)) {
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal datum : this.data) {
            if (datum.getName().equals(name) && datum.getCaretaker().equals(caretaker)) {
                return datum;
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        int maxAge = Integer.MIN_VALUE;
        Animal oldest = null;
        for (Animal datum : this.data) {
            if (datum.getAge() > maxAge) {
                maxAge = datum.getAge();
                oldest = datum;
            }
        }
        return oldest;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        sb.append(System.lineSeparator());

        for (Animal datum : data) {
            sb.append(datum.getName()).append(" ").append(datum.getCaretaker());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
