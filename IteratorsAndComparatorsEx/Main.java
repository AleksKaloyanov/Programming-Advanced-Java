package IteratorsAndComparatorsEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            if (cmd.equals("Create")) {
                String name = tokens[2];
                if (tokens[1].equals("Pet")) {
                    int age = Integer.parseInt(tokens[3]);
                    String kind = tokens[4];
                    Pet pet = new Pet(name, age, kind);
                    pets.put(name, pet);
                } else {
                    int rooms = Integer.parseInt(tokens[3]);
                    if (rooms % 2 != 1) {
                        System.out.println("Invalid Operation!");
                    } else {
                        Clinic clinicc = new Clinic(name, rooms);
                        clinics.put(name, clinicc);
                    }
                }
            } else if (cmd.equals("Add")) {
                String petName = tokens[1];
                String clinicName = tokens[2];
                System.out.println(clinics.get(clinicName).add(pets.remove(petName)));
            } else if (cmd.equals("Release")) {
                String name = tokens[1];
                System.out.println(clinics.get(name).release());
            } else if (cmd.equals("HasEmptyRooms")) {
                String name = tokens[1];
                System.out.println(clinics.get(name).hasEmptyRooms());
            } else if (cmd.equals("Print")) {
                String name = tokens[1];
                if (tokens.length > 2) {
                    int room = Integer.parseInt(tokens[2]);
                    clinics.get(name).print(room);
                } else {
                    for (Pet pet : clinics.get(name)) {
                        if (pet == null) {
                            System.out.println("Room empty");
                        } else {
                            System.out.println(pet);
                        }
                    }
                }
            }
        }
    }
}
