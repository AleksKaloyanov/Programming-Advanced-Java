package JavaExamsAdvanced.August18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TreasureHunt {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] map = new String[dimensions[0]][dimensions[1]];
        int[] curPos = new int[2];
        int[] finPos = new int[2];

        for (int i = 0; i < map.length; i++) {
            String line = reader.readLine();
            String[] elements = line.split("\\s+");
            if (line.contains("X") || line.contains("Y")) {
                for (int j = 0; j < elements.length; j++) {
                    if (elements[j].equals("X")) {
                        finPos[0] = i;
                        finPos[1] = j;
                    } else if (elements[j].equals("Y")) {
                        curPos[0] = i;
                        curPos[1] = j;
                    }
                }
            }
            map[i] = elements;
        }

        StringBuilder directions = new StringBuilder();

        String input = "";

        String separator = "";
        while (!"Finish".equals(input = reader.readLine())) {
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
            if (row < 0 || col < 0 || row >= map.length || col >= map[row].length) {
                row = curPos[0];
                col = curPos[1];
            } else {
                if (map[row][col].equals("-")) {
                    curPos[0] = row;
                    curPos[1] = col;
                    directions.append(separator).append(input);
                    separator = ", ";
                } else {
                    if (map[row][col].equals("T")) {
                        row = curPos[0];
                        col = curPos[1];
                    } else {
                        curPos[0] = row;
                        curPos[1] = col;
                        directions.append(separator).append(input);
                        separator = ", ";
                    }
                }
            }
        }

        if (curPos[0] == finPos[0] && curPos[1] == finPos[1]) {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + directions);
        } else {
            System.out.println("The map is fake!");
        }
    }
}
