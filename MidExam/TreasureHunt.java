package MidExam;

import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] treasures = input.split("\\|");
        List<String> chest = new ArrayList<>(Arrays.asList(treasures));
        input = sc.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            if (cmd.equals("Loot")) {
                for (int i = 1; i < tokens.length; i++) {

                    if (!chest.contains(tokens[i])) {
                        chest.add(0, tokens[i]);
                    }
                }
            } else if (cmd.equals("Drop")) {
                int index = Integer.parseInt(tokens[1]);

                if (isValid(index, chest)) {
                    chest.add(chest.remove(index));
                }
            } else if (cmd.equals("Steal")) {
                int count = Integer.parseInt(tokens[1]);

                List<String> temp = new ArrayList<>();

                if (count > chest.size()) {
                    for (int i = 0; i < chest.size(); i++) {
                        temp.add(chest.remove(i));
                    }
                } else {
                    for (int i = 0; i < count; i++) {
                        temp.add(chest.remove(chest.size() - 1));
                    }
                    Collections.reverse(temp);
                }

                String separator = "";

                for (int i = 0; i < temp.size(); i++) {
                    System.out.print(separator + temp.get(i));
                    separator = ", ";
                }
                System.out.println();
            }
            input = sc.nextLine();
        }
        if (chest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            int counter = 0;

            for (String s : chest) {
                sum += s.length();
                counter++;
            }

            System.out.printf("Average treasure gain: %.2f pirate credits.", sum / counter);
        }
    }

    private static boolean isValid(int index, List<String> chest) {
        return index >= 0 && index < chest.size();
    }
}
