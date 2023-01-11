package JavaExamsAdvanced.October22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RallyRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String car = reader.readLine();

        String[][] raceField = new String[n][n];

        int[] curPos = {0, 0};
        int[] finPos = new int[2];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            raceField[i] = line;
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("F")) {
                    finPos[0] = i;
                    finPos[1] = j;
                }
            }
        }

        String input = "";

        int distance = 0;
        boolean hasFinished = false;

        while (!"End".equals(input = reader.readLine())) {
            switch (input) {
                case "left":
                    curPos[1]--;
                    break;
                case "right":
                    curPos[1]++;
                    break;
                case "up":
                    curPos[0]--;
                    break;
                case "down":
                    curPos[0]++;
                    break;
            }
            if (raceField[curPos[0]][curPos[1]].equals(".")) {
                distance += 10;
            } else if (raceField[curPos[0]][curPos[1]].equals("T")) {
                distance += 30;
                raceField[curPos[0]][curPos[1]] = ".";
                for (int i = 0; i < raceField.length; i++) {
                    for (int j = 0; j < raceField[i].length; j++) {
                        if (raceField[i][j].equals("T")) {
                            curPos[0] = i;
                            curPos[1] = j;
                            raceField[i][j] = ".";
                        }
                    }
                }
            } else if (curPos[0] == finPos[0] && curPos[1] == finPos[1]) {
                distance += 10;
                hasFinished = true;
                break;
            }
        }

        raceField[curPos[0]][curPos[1]] = "C";

        if (hasFinished) {
            System.out.println("Racing car " + car + " finished the stage!");
        } else {
            System.out.println("Racing car " + car + " DNF.");
        }
        System.out.println("Distance covered " + distance + " km.");
        for (int i = 0; i < raceField.length; i++) {
            for (int j = 0; j < raceField[i].length; j++) {
                System.out.print(raceField[i][j]);
            }
            System.out.println();
        }
    }
}
