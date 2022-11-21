package DefiningClassesEx.CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        List<Cat> cats = new ArrayList<>();

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            if (breed.equals("Siamese")) {
                Siamese siamese = new Siamese(name, Double.parseDouble(tokens[2]));
                cats.add(siamese);
            } else if (breed.equals("Cymric")) {
                Cymric cymric = new Cymric(name, Double.parseDouble(tokens[2]));
                cats.add(cymric);
            } else {
                StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, Double.parseDouble(tokens[2]));
                cats.add(streetExtraordinaire);
            }
        }

        String toPrint = reader.readLine();

        for (Cat cat : cats) {
            if (cat.getName().equals(toPrint)) {
                System.out.printf("%s %s %.2f%n", cat.getClass().getSimpleName(), cat.getName(), cat.getFeature());
            }
        }
    }
}
