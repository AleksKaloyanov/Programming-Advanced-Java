package DefiningClassesEx.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(reader.readLine());

        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            Car car = new Car(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            cars.add(car);
        }

        String input = "";

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String model = tokens[1];
            int km = Integer.parseInt(tokens[2]);

            for (Car car : cars) {
                if (car.getModel().equals(model)) {
                    car.drive(km);
                }
            }
        }

        cars
                .forEach(e -> {
                    System.out.printf("%s %.2f %d%n", e.getModel(), e.getFuelAmount(), e.getMileage());
                });
    }
}
