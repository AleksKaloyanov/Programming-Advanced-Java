package DefiningClassesEx.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(model, power);
            if (tokens.length == 4) {
                engine.setDisplacement(tokens[2]);
                engine.setEfficiency(tokens[3]);
            } else if (tokens.length == 3) {
                String s = tokens[2];
                if (Character.isDigit(s.charAt(0))) {
                    engine.setDisplacement(s);
                } else {
                    engine.setEfficiency(s);
                }
            }
            engines.add(engine);
        }

        int m = Integer.parseInt(reader.readLine());

        List<Car> cars = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            String e = tokens[1];
            Engine engine1 = engines.get(0);
            for (Engine engine : engines) {
                if (engine.getModel().equals(e)) {
                    engine1 = engine;
                }
            }
            Car car = new Car(model, engine1);

            if (tokens.length == 4) {
                car.setWeight(tokens[2]);
                car.setColor(tokens[3]);
            } else if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    car.setWeight(tokens[2]);
                } else {
                    car.setColor(tokens[2]);
                }
            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.print(car.toString());
        }
    }
}
