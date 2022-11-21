package AssociativeArrays;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String s : input) {
            String wordInLowerCase = s.toLowerCase();
            if (!counts.containsKey(wordInLowerCase)) {
                counts.put(wordInLowerCase, 1);
            } else {
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
            }
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            if (e.getValue() % 2 == 1) {
                list.add(e.getKey());
            }
        }
        String separator = "";
        for (String s : list) {
            System.out.print(separator + s);
            separator = ", ";
        }
    }
}
