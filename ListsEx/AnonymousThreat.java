package ListsEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> data = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = sc.nextLine();


        while (!input.equals("3:1")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            if (cmd.equals("merge")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int finishIndex = Integer.parseInt(tokens[2]);

                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (finishIndex > data.size() - 1) {
                    finishIndex = data.size() - 1;
                }

                int cnt = startIndex;
                for (int i = startIndex; i < finishIndex; i++) {
                    String concat = data.get(startIndex) + data.remove(cnt + 1);
                    data.set(cnt, concat);
                }
            } else {
                int index = Integer.parseInt(tokens[1]);
                int partitions = Integer.parseInt(tokens[2]);

                String forParting = data.get(index);
                int length = forParting.length();
                boolean isEqual = true;
                if (length % partitions != 0) {
                    isEqual = false;
                }

                List<String> newList = new ArrayList<>();
                if (isEqual) {
                    int partLength = length/partitions;
                    int cnt = 0;
                    for (int i = 0; i < partitions; i++) {
                        String concat = "";
                        for (int j = 0; j < partLength; j++) {
                            concat+=forParting.charAt(cnt);
                            cnt++;
                        }
                        newList.add(concat);
                    }
                }
            }
            input = sc.nextLine();
        }
        for (String datum : data) {
            System.out.print(datum + " ");
        }
    }
}

