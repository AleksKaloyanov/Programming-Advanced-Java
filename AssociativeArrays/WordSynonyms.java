package AssociativeArrays;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.printf("%s - ",entry.getKey());
            String separator = "";
            for (String s : entry.getValue()) {
                System.out.print(separator+s);
                separator=", ";
            }
            System.out.println();
        }
    }
}
