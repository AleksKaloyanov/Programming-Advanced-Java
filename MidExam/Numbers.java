package MidExam;

import java.util.*;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        double sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        double avg = sum / numbers.length;

        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            if (number > avg) {
                list.add(number);
            }
        }

        Collections.sort(list);
        Collections.reverse(list);

        if (list.isEmpty()) {
            System.out.println("No");
        } else {
            if (list.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    System.out.print(list.get(i) + " ");
                }
            } else {
                for (Integer integer : list) {
                    System.out.print(integer + " ");
                }
            }
        }
    }
}