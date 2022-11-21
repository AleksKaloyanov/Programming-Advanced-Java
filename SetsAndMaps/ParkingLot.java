package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = "";

        Set<String> parking = new LinkedHashSet<>();

        while (!"END".equals(input = sc.nextLine())) {
            String cmd = input.substring(0, input.indexOf(","));
            String plate = input.substring(input.indexOf(",")+1);

            if (cmd.equals("IN")) {
                parking.add(plate);
            } else {
                parking.remove(plate);
            }
        }
        if (parking.isEmpty()){
            System.out.println("Parking lot is Empty");
        }

        for (String s : parking) {
            System.out.println(s);
        }
    }
}
