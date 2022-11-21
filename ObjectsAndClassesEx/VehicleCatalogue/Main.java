package ObjectsAndClassesEx.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);

            Vehicle vehicle;
            if (type.equals("car")) {
                vehicle = new Vehicle("Car", model, color, horsepower);
            } else {
                vehicle = new Vehicle("Truck", model, color, horsepower);
            }
            vehicles.add(vehicle);

            input = sc.nextLine();
        }
        input = sc.nextLine();

        while (!input.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (input.equals(vehicle.getModel())) {
                    System.out.print(vehicle);
                }
            }
            input = sc.nextLine();
        }

        double carsHP = calcHp(vehicles, "Car");
        double truckHP = calcHp(vehicles, "Truck");

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsHP);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", truckHP);
    }

    private static double calcHp(List<Vehicle> vehicles, String type) {
        double sum = 0;
        int counter = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(type)) {
                sum += vehicle.getHorsepower();
                counter++;
            }
        }
        if (counter == 0) {
            return 0;
        }
        return sum / counter;
    }
}

