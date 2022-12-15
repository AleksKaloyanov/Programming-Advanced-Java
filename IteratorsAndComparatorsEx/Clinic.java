package IteratorsAndComparatorsEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Clinic implements Iterable<Pet> {
    private String name;
    private int rooms;
    private Map<Integer, Pet> pets;

    public Clinic(String name, int rooms) {
        setName(name);
        setRooms(rooms);
        pets = new HashMap<>();
        fillRooms();
    }

    private void fillRooms() {
        for (int i = 1; i <= this.rooms; i++) {
            pets.put(i, null);
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getRooms() {
        return rooms;
    }

    private void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean add(Pet pet) {
        int middleRoom = this.rooms / 2 + 1;

        for (int i = 0; i < middleRoom; i++) {
            if (this.pets.get(middleRoom - i) == null) {
                this.pets.put(middleRoom - i, pet);
                return true;
            } else if (this.pets.get(middleRoom + i) == null) {
                this.pets.put(middleRoom + i, pet);
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int middleRoom = this.rooms / 2 + 1;
        for (int i = middleRoom; i < this.pets.size(); i++) {
            if (this.pets.get(i) != null) {
                this.pets.put(i, null);
                return true;
            }
        }

        for (int i = 0; i < middleRoom; i++) {
            if (this.pets.get(i) != null) {
                this.pets.put(i, null);
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (int i = 1; i <= this.rooms; i++) {
            if (this.pets.get(i) == null) {
                return true;
            }
        }
        return false;
    }

    public void print(int room) {
        System.out.println(this.pets.get(room));
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 1;

            @Override
            public boolean hasNext() {
                return index <= rooms;
            }

            @Override
            public Pet next() {
                return pets.get(index++);
            }
        };
    }
}
