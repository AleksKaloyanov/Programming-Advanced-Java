package JavaExamsAdvanced.Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armory {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] armory = new String[n][n];
        int[] curPos = new int[2];
        int total = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] line = input.split("");
            if (input.contains("A")) {
                for (int j = 0; j < line.length; j++) {
                    if (line[j].equals("A")) {
                        curPos[0] = i;
                        curPos[1] = j;
                    }
                }
            }
            armory[i] = line;
        }

        while (total < 65) {
            int row = curPos[0];
            int col = curPos[1];
            String input = br.readLine();
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
            if (row < 0 || col < 0 || row >= n || col >= n) {
                System.out.println("I do not need more swords!");
                armory[curPos[0]][curPos[1]] = "-";
                break;
            } else {
                armory[curPos[0]][curPos[1]] = "-";
                if (armory[row][col].equals("-")) {
                    armory[row][col] = "A";
                } else if (armory[row][col].equals("M")) {
                    armory[row][col] = "-";
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (armory[i][j].equals("M")) {
                                row = i;
                                col = j;
                                armory[i][j] = "A";
                            }
                        }
                    }
                } else {
                    total += Integer.parseInt(armory[row][col]);
                    armory[row][col] = "A";
                }
                curPos[0] = row;
                curPos[1] = col;
            }
        }

        if (total >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.println("The king paid " + total + " gold coins.");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(armory[i][j]);
            }
            System.out.println();
        }
    }
}
