package JavaExamsAdvanced.Matrices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PawnWars {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[8][8];
        int[] wPos = new int[2];
        int[] bPos = new int[2];

        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            String[] line = input.split("");
            if (input.contains("w") || input.contains("b")) {
                for (int j = 0; j < line.length; j++) {
                    if (line[j].equals("w")) {
                        wPos[0] = i;
                        wPos[1] = j;
                        break;
                    }
                    if (line[j].equals("b")) {
                        bPos[0] = i;
                        bPos[1] = j;
                        break;
                    }
                }
            }
        }

        boolean isOver = false;
        boolean canHit = wPos[1] + 1 == bPos[1] || wPos[1] - 1 == bPos[1];

        Map<Integer, Integer> positions = new HashMap<>();
        positions.put(0, 8);
        positions.put(1, 7);
        positions.put(2, 6);
        positions.put(3, 5);
        positions.put(4, 4);
        positions.put(5, 3);
        positions.put(6, 2);
        positions.put(7, 1);


        while (!isOver) {
            int wRow = wPos[0];
            int bRow = bPos[0];
            if (!canHit) {
                wRow--;
                if (wRow == 0) {
                    isOver = true;
                    char position = (char) (wPos[1] + 97);
                    System.out.println("Game over! White pawn is promoted to a queen at " + position + "8.");
                    break;
                }
                bRow++;
                if (bRow == 7) {
                    isOver = true;
                    char position = (char) (bPos[1] + 97);
                    System.out.println("Game over! Black pawn is promoted to a queen at " + position + "1.");
                    break;
                }
            } else {
                if (wRow - 1 == bRow) {
                    isOver = true;
                    char position = (char) (bPos[1] + 97);
                    System.out.println("Game over! White capture on " + position + positions.get(bRow)+".");
                    break;
                } else {
                    wRow--;
                }
                if (bRow + 1 == wRow) {
                    isOver = true;
                    char position = (char) (wPos[1] + 97);
                    System.out.println("Game over! Black capture on " + position + positions.get(wRow)+".");
                    break;
                } else {
                    bRow++;
                }

            }
            wPos[0] = wRow;
            bPos[0] = bRow;
        }
    }
}
