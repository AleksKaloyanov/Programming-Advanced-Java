package DefiningClasses.CarConstructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");
            String brand = tokens[0];
            Car car = new Car(brand);
            if (tokens.length > 1) {
                String model = tokens[1];
                int horsepower = Integer.parseInt(tokens[2]);
                car.setModel(model);
                car.setHorsepower(horsepower);
            }
            System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsepower());
        }
    }
}
