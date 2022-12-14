package Generics.GenericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(reader.readLine());
            box.add(input);
        }

        double toCompare = Double.parseDouble(reader.readLine());

        System.out.println(box.compareTo(toCompare));
    }
}
