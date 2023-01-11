package JavaExamsAdvanced.Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int presents = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String[][] neighbourhood = new String[n][n];
        int[] curPos = new int[2];
        int happyKids = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] line = input.split("\\s+");
            neighbourhood[i] = line;
            if (input.contains("S")) {
                for (int j = 0; j < n; j++) {
                    if (neighbourhood[i][j].equals("S")) {
                        curPos[0] = i;
                        curPos[1] = j;
                    }
                }
            }
        }

        String input = "";

        while (!"Christmas morning".equals(input = br.readLine())) {
            int row = curPos[0];
            int col = curPos[1];
            switch (input) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if (row >= 0 && col >= 0 && row < n && col < n) {
                if (neighbourhood[row][col].equals("-")) {
                    neighbourhood[curPos[0]][curPos[1]] = "-";
                    neighbourhood[row][col] = "S";
                } else if (neighbourhood[row][col].equals("V")) {
                    neighbourhood[curPos[0]][curPos[1]] = "-";
                    neighbourhood[row][col] = "S";
                    presents--;
                    happyKids++;
                    if (presents == 0) {
                        break;
                    }
                } else if (neighbourhood[row][col].equals("X")) {
                    neighbourhood[curPos[0]][curPos[1]] = "-";
                    neighbourhood[row][col] = "S";
                } else if (neighbourhood[row][col].equals("C")) {
                    neighbourhood[curPos[0]][curPos[1]] = "-";
                    neighbourhood[row][col] = "S";
                    for (int i = -1; i <= 1; i++) {
                        if (neighbourhood[row + i][col].equals("V") || neighbourhood[row + i][col].equals("X")) {
                            neighbourhood[row + i][col] = "-";
                            presents--;
                            happyKids++;
                            if (presents == 0) {
                                break;
                            }
                        }
                        if (neighbourhood[row][col + i].equals("V") || neighbourhood[row][col + 1].equals("X")) {
                            neighbourhood[row][col + i] = "-";
                            presents--;
                            happyKids++;
                            if (presents == 0) {
                                break;
                            }
                        }
                    }
                }
                curPos[0] = row;
                curPos[1] = col;
            }
        }
        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(neighbourhood[i][j] + " ");
                if (neighbourhood[i][j].equals("V")) {
                    c++;
                }
            }
            System.out.println();
        }

        if (c != 0) {
            System.out.println("No presents for " + c + " nice kid/s.");
        } else {
            System.out.println("Good job, Santa! " + happyKids + " happy nice kid/s.");
        }
    }
}
