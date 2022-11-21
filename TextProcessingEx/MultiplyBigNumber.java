package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String bigNum = reader.readLine();
        int multiplier = Integer.parseInt(reader.readLine());
        if (multiplier == 0) {
            System.out.println(0);
            return;
        }
        int reminder = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int current = Integer.parseInt(String.valueOf(bigNum.charAt(i)));
            int result = current * multiplier + reminder;
            sb.append(result % 10);
            reminder = result / 10;
        }

        if (reminder != 0) {
            sb.append(reminder);
        }

        StringBuilder sb2 = new StringBuilder(sb.reverse());
        for (int i = 0; i < sb2.length(); i++) {
            if (Integer.parseInt(String.valueOf(sb2.charAt(0))) == 0) {
                sb2.deleteCharAt(0);
            }

        }

        System.out.println(sb2);
    }
}
