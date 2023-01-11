package JavaExamsAdvanced.June25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[][] field = new String[n][n];

        List<String> movements = Arrays.stream(reader.readLine().split(","))
                .collect(Collectors.toList());

        int[] curPos = new int[2];

        for (int i = 0; i < field.length; i++) {
            String input = reader.readLine();
            String[] line = input.split("\\s+");
            if (input.contains("D")) {
                for (int j = 0; j < line.length; j++) {
                    if (line[j].equals("D")) {
                        curPos[0] = i;
                        curPos[1] = j;
                    }
                }
            }
            field[i] = line;
        }

        int total = 0;
        boolean isCaught = false;

        while (!movements.isEmpty()) {
            String cmd = movements.remove(0);
            int row = curPos[0];
            int col = curPos[1];
            switch (cmd) {
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

            if (row < 0 || col < 0 || row >= field.length || col >= field.length) {
                System.out.println("You cannot leave the town, there is police outside!");
            } else {
                if (field[row][col].equals("+")) {
                    field[curPos[0]][curPos[1]] = "+";
                    field[row][col] = "D";
                } else if (field[row][col].equals("$")) {
                    field[curPos[0]][curPos[1]] = "+";
                    field[row][col] = "D";
                    total += row * col;
                    System.out.println("You successfully stole " + row * col + "$.");
                } else if (field[row][col].equals("P")) {
                    field[curPos[0]][curPos[1]] = "+";
                    field[row][col] = "#";
                    System.out.println("You got caught with " + total + "$, and you are going to jail.");
                    isCaught = true;
                    break;
                }
                curPos[0] = row;
                curPos[1] = col;
            }
            if (isCaught) {
                break;
            }
        }
        if (!isCaught) {
            System.out.println("Your last theft has finished successfully with " + total + "$ in your pocket.");
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.println();
        }
    }
}
