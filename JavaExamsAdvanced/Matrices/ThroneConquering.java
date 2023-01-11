package JavaExamsAdvanced.Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThroneConquering {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int energy = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        String[][] field = new String[n][];
        int[] curPos = new int[2];
        int[] helenPos = new int[2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] line = input.split("");
            if (input.contains("P") || input.contains("H")) {
                for (int j = 0; j < line.length; j++) {
                    if (line[j].equals("P")) {
                        curPos[0] = i;
                        curPos[1] = j;
                    } else if (line[j].equals("H")) {
                        helenPos[0] = i;
                        helenPos[1] = j;
                    }
                }
            }
            field[i] = line;
        }

        boolean isAbducted = false;

        while (!isAbducted) {
            String input = br.readLine();
            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];
            int enemyRow = Integer.parseInt(tokens[1]);
            int enemyCol = Integer.parseInt(tokens[2]);

            field[enemyRow][enemyCol] = "S";

            int curRow = curPos[0];
            int curCol = curPos[1];

            switch (cmd) {
                case "up":
                    curRow--;
                    break;
                case "down":
                    curRow++;
                    break;
                case "left":
                    curCol--;
                    break;
                case "right":
                    curCol++;
                    break;
            }

            if (curRow < 0 || curCol < 0 || curRow >= field.length || curCol >= field[0].length) {
                energy--;
            } else {
                energy--;
                field[curPos[0]][curPos[1]] = "-";
                if (curRow == helenPos[0] && curCol == helenPos[1]) {
                    field[curRow][curCol] = "-";
                    break;
                }

                if (field[curRow][curCol].equals("S")) {
                    if (energy <= 2) {
                        field[curRow][curCol] = "X";
                        System.out.println("Paris died at " + curRow + ";" + curCol+".");
                        break;
                    } else {
                        field[curRow][curCol] = "P";
                        energy -= 2;
                    }
                } else {
                    if (energy == 0) {
                        field[curRow][curCol] = "X";
                        System.out.println("Paris died at " + curRow + ";" + curCol+".");
                        break;
                    } else {
                        field[curRow][curCol] = "P";
                    }
                }
                curPos[0] = curRow;
                curPos[1] = curCol;
            }
        }

        if (isAbducted) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
