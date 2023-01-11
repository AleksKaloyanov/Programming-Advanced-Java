package JavaExamsAdvanced.August18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> plates = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> cars = Arrays.stream(reader.readLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int days = 0;
        int registered = 0;

        while (!plates.isEmpty() && !cars.isEmpty()) {
            int platesToday = plates.remove(0);
            int carsToday = cars.remove(cars.size() - 1);

            if (carsToday * 2 < platesToday) {
                platesToday -= carsToday * 2;
                plates.add(platesToday);
                registered += carsToday;
            } else if (carsToday * 2 > platesToday) {
                carsToday -= platesToday / 2;
                cars.add(0, carsToday);
                registered += platesToday / 2;
            } else {
                registered += carsToday;
            }

            days++;
        }
        System.out.println(registered + " cars were registered for " + days + " days!");

        if (!cars.isEmpty()) {
            int total = 0;
            for (int car : cars) {
                total += car;
            }
            System.out.println(total +" cars remain without license plates!");
        } else if (!plates.isEmpty()) {
            int total =0;
            for (int plate : plates) {
                total+=plate;
            }
            System.out.println(total+" license plates remain!");
        }else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
