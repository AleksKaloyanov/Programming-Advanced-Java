package AssociativeArraysEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        Map<String, List<String>> companies = new LinkedHashMap<>();

        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" -> ");
            String name = tokens[0];
            String id = tokens[1];

            companies.putIfAbsent(name, new ArrayList<>());
            if (!companies.get(name).contains(id)) {
                companies.get(name).add(id);
            }
        }
        companies
                .forEach((key, value) -> {
                    System.out.printf("%s%n", key);
                    value
                            .forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}
