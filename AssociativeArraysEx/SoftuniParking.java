package AssociativeArraysEx;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftuniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, String> parking = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String cmd = input[0];
            String name = input[1];

            if (cmd.equals("register")) {
                String plate = input[2];
                if (!parking.containsKey(name)) {
                    parking.put(name, plate);
                    System.out.printf("%s registered %s successfully%n", name, plate);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", parking.get(name));
                }
            } else {
                if (parking.containsKey(name)) {
                    parking.remove(name);
                    System.out.println(name + " unregistered successfully");
                } else {
                    System.out.printf("ERROR: user %s not found%n", name);
                }
            }
        }
        parking
                .entrySet()
                .forEach(e -> System.out.printf("%s => %s%n", e.getKey(), e.getValue()));
    }
}
