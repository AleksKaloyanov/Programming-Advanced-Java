package JavaExams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class NeedForSpeed3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> carMiles = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        String input = "";

        for (int i = 0; i < n; i++) {
            input = reader.readLine();
            String[] tokens = input.split("\\|");
            String model = tokens[0];
            int mileage = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            carMiles.put(model, mileage);
            carFuel.put(model, fuel);
        }

        while (!"Stop".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+:\\s++");
            String cmd = tokens[0];
            String car = tokens[1];
            int currentFuel = carFuel.get(car);
            int currentMileage = carMiles.get(car);

            if ("Drive".equals(cmd)) {
                int distance = Integer.parseInt(tokens[2]);
                int fuel = Integer.parseInt(tokens[3]);

                if (currentFuel >= fuel) {
                    carFuel.put(car, currentFuel - fuel);
                    carMiles.put(car, currentMileage + distance);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                    if (carMiles.get(car) >= 100000) {
                        carFuel.remove(car);
                        carMiles.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }

                } else {
                    System.out.println("Not enough fuel to make that ride");
                }
            } else if ("Refuel".equals(cmd)) {
                int fuel = Integer.parseInt(tokens[2]);

                if (currentFuel + fuel >= 75) {
                    carFuel.put(car, 75);
                    fuel = 75 - currentFuel;
                } else {
                    carFuel.put(car, carFuel.get(car) + fuel);
                }
                System.out.printf("%s refueled with %d liters%n", car, fuel);
            } else if ("Revert".equals(cmd)) {
                int km = Integer.parseInt(tokens[2]);

                if (currentMileage - km < 10000) {
                    carMiles.put(car, 10000);
                } else {
                    carMiles.put(car, carMiles.get(car) - km);
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                }
            }
        }

        for (Map.Entry<String, Integer> s : carFuel.entrySet()) {
            String car = s.getKey();
            int fuel = s.getValue();
            int mileage = carMiles.get(car);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel);
        }
    }
}
