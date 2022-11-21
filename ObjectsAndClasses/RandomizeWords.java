package ObjectsAndClasses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> words = Arrays.stream(sc.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());

        Random rnd = new Random();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(rnd.nextInt(words.size()));

            System.out.println();
        }
    }
}
