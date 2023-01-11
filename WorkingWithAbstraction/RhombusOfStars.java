package WorkingWithAbstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.print(createTopHalf(n));
        System.out.print(createBottomHalf(n));
    }

    private static String createTopHalf(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(repeatChar(' ', n - i));
            s.append(repeatString("* ", i));
        }
        return s.toString();
    }

    private static String createBottomHalf(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            s.append(repeatChar(' ', n - i));
            s.append(repeatString("* ", i));
        }
        return s.toString();
    }

    private static String repeatString(String s, int n) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(s);
        }
        out.append(System.lineSeparator());
        return out.toString();
    }

    private static String repeatChar(char c, int count) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < count; i++) {
            out.append(c);
        }
        return out.toString();
    }
}
