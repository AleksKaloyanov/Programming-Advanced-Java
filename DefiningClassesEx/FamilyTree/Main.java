package DefiningClassesEx.FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> peopleByName = new HashMap<>();
        Map<String, List<String>> parentChild = new HashMap<>();

        String owner = reader.readLine();

        String input = "";

        while (!"End".equals(input = reader.readLine())) {
            if (input.contains(" - ")) {
                String[] tokens = input.split(" - ");
                String parent = tokens[0];
                String child = tokens[1];
                parentChild.putIfAbsent(parent, new ArrayList<>());
                parentChild.get(parent).add(child);
            } else {
                String name = input.substring(0, input.lastIndexOf(" "));
                String date = input.substring(input.lastIndexOf(" "));
                peopleByName.putIfAbsent(name, new Person(name, date));
                if (parentChild.containsKey(name));
            }

        }
    }
}
