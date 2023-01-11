package JavaExamsAdvanced.August18.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }

    public boolean remove(String name) {
        for (Elephant datum : this.data) {
            if (datum.getName().equals(name)) {
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant datum : this.data) {
            if (datum.getRetiredFrom().equals(retiredFrom)) {
                return datum;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        int max = Integer.MIN_VALUE;
        Elephant elephant = null;
        for (Elephant datum : this.data) {
            if (datum.getAge() > max) {
                max = datum.getAge();
                elephant = datum;
            }
        }
        return elephant;
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Saved elephants in the park:").append(System.lineSeparator());
        for (Elephant datum : this.data) {
            sb.append(datum.getName()).append(" came from: ").append(datum.getRetiredFrom())
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
