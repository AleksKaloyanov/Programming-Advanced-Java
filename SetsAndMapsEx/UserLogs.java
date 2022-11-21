package SetsAndMapsEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        String input = "";

        while (!"end".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String ad = tokens[0];
            String u = tokens[2];
            String[] tok1 = ad.split("=");
            String[] tok3 = u.split("=");
            String ip = tok1[1];
            String username = tok3[1];

            logs.putIfAbsent(username, new LinkedHashMap<>());
            logs.get(username).putIfAbsent(ip, 0);
            logs.get(username).put(ip, logs.get(username).get(ip) + 1);
        }

        logs.entrySet()
                .forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    int count = 0;
                    Map<String, Integer> value = e.getValue();

                    for (Map.Entry<String, Integer> secondMap : value.entrySet()) {

                        String format =
                                (count++ == value.size() - 1)
                                        ? "%s => %d.%n"
                                        : "%s => %d, ";

                        System.out.printf(format, secondMap.getKey(), secondMap.getValue());
                    }
                });
    }
}
