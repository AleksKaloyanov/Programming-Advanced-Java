package MultidimensionalArraysEx;

import java.util.Scanner;

//NOT MINE!!!

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double dmg = Double.parseDouble(sc.nextLine());

        double bossHp = 3000000;
        int playerHp = 18500;
        int startingPlRow = 7;
        int startingPlCol = 7;

        String lastSpellName = "";
        boolean isPlagued = false;

        while (bossHp > 0 && playerHp > 0) {
            bossHp -= dmg;

            if (isPlagued) {
                playerHp -= 3500;
                isPlagued = false;
            }
            if (bossHp < 0) {
                break;
            }
            if (playerHp < 0) {
                break;
            }

            String[] tokens = sc.nextLine().split("\\s+");
            String spell = tokens[0];
            int spellRow = Integer.parseInt(tokens[1]);
            int spellCol = Integer.parseInt(tokens[2]);

            boolean[][] field = new boolean[15][15];

            for (int i = spellRow - 1; i <= spellRow + 1; i++) {
                if (i >= 0 && i < field.length) {
                    for (int j = spellCol - 1; j <= spellCol + 1; j++) {
                        if (j >= 0 && j < field[spellRow].length) {
                            field[i][j] = true;
                        }
                    }
                }
            }

            if (field[startingPlRow][startingPlCol]) {
                if (isValidRow(field, startingPlRow - 1) && !field[startingPlRow - 1][startingPlCol]) {
                    startingPlRow--;
                } else if (isValidCow(field, startingPlCol + 1) && !field[startingPlRow][startingPlCol + 1]) {
                    startingPlCol++;
                } else if (isValidRow(field, startingPlRow + 1) && !field[startingPlRow + 1][startingPlCol]) {
                    startingPlRow++;
                } else if (isValidCow(field, startingPlCol - 1) && !field[startingPlRow][startingPlCol - 1]) {
                    startingPlCol--;
                }
            }

            if (field[startingPlRow][startingPlCol]) {
                switch (spell) {
                    case "Cloud":
                        playerHp -= 3500;
                        isPlagued = true;
                        lastSpellName = "Plague Cloud";
                        break;

                    case "Eruption":
                        playerHp -= 6000;
                        lastSpellName = spell;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid spell: " + spell);
                }
            }
        }
        if (bossHp <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHp);
        }

        if (playerHp <= 0) {
            System.out.println("Player: Killed by " + lastSpellName);
        } else {
            System.out.printf("Player: %d%n", playerHp);
        }
        System.out.println("Final position: " + startingPlRow + ", " + startingPlCol);
    }

    private static boolean isValidCow(boolean[][] field, int startingPlCol) {
        return startingPlCol >= 0 && startingPlCol < field.length;
    }

    private static boolean isValidRow(boolean[][] field, int startingPlRow) {
        return startingPlRow >= 0 && startingPlRow < field.length;
    }
}
