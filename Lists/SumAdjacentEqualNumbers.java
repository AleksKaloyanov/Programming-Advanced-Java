package Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        List<Double> numbers = new ArrayList<>();

        for (String s : input) {
            double num = Double.parseDouble(s);
            numbers.add(num);
        }

        for (int i = 0; i < numbers.size()-1;) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i+1);
                i=0;
            }else {
                i++;
            }

        }

        for (Double number : numbers) {
            DecimalFormat df = new DecimalFormat("0.#");
            System.out.print(df.format(number) + " ");
        }
    }
}
