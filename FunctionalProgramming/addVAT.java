package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class addVAT {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> addVAT = n -> n * 1.20;

        System.out.println("Prices with VAT:");
        Arrays.stream(reader.readLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .forEach(n -> {
                    System.out.printf("%.2f%n", addVAT.apply(n));
                });
    }
}
