package DefiningClassesEx.RawData;

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
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String type = tokens[4];
            double pressure1 = Double.parseDouble(tokens[5]);
            int age1 = Integer.parseInt(tokens[6]);
            double pressure2 = Double.parseDouble(tokens[7]);
            int age2 = Integer.parseInt(tokens[8]);
            double pressure3 = Double.parseDouble(tokens[9]);
            int age3 = Integer.parseInt(tokens[10]);
            double pressure4 = Double.parseDouble(tokens[11]);
            int age4 = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            Tires tire1 = new Tires(pressure1, age1);
            Tires tire2 = new Tires(pressure2, age2);
            Tires tire3 = new Tires(pressure3, age3);
            Tires tire4 = new Tires(pressure4, age4);

            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            cars.add(car);
        }

        String input = reader.readLine();
        if (input.equals("fragile")) {
            for (Car car : cars) {
                if (car.getType().equals("fragile")) {
                    if (carPressure(car)) {
                        System.out.println(car.getModel());
                    }
                }
            }
        } else if (input.equals("flamable")) {
            for (Car car : cars) {
                if (car.getType().equals("flamable")) {
                    if (carPower(car)) {
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }

    private static boolean carPower(Car car) {
        return car.getPower() > 250;
    }

    private static boolean carPressure(Car car) {
        double[] pressure = car.getPressure();
        for (double v : pressure) {
            if (v < 1) {
                return true;
            }
        }
        return false;
    }
}
