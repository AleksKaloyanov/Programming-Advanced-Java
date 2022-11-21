package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers1 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> numbers2 = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        while (!numbers1.isEmpty() && !numbers2.isEmpty()) {
            result.add(numbers1.remove(0));
            result.add(numbers2.remove(0));
        }

        if (numbers1.isEmpty()) {
            result.addAll(numbers2);
        } else {
            result.addAll(numbers1);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
