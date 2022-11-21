package MidExam;

import java.util.Scanner;
import java.util.Arrays;

public class TheLift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = Integer.parseInt(sc.nextLine());
        int[] lift = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cap = 4;


        for (int i = 0; i < lift.length; i++) {
            int currentPeople = lift[i];
            int newPeople = 0;
            if (currentPeople < 4) {
                newPeople = 4 - currentPeople;
                if (people < 4) {
                    newPeople = people;
                }
                lift[i] = newPeople + currentPeople;
                people -= newPeople;
                if (people <= 0) {
                    break;
                }
            }
        }
        if (peopleAreLeft(people)) {
            System.out.println("There isn't enough space! " + people + " people in a queue!");
            printLift(lift);
        } else if (!peopleAreLeft(people) && wagonsLeft(lift)){
            System.out.println("The lift has empty spots!");
            printLift(lift);
        }else if (!peopleAreLeft(people) && !wagonsLeft(lift)){
            printLift(lift);
        }
    }

    private static void printLift(int[] lift) {
        for (int i : lift) {
            System.out.print(i+" ");
        }
    }

    private static boolean wagonsLeft(int[] lift) {
        for (int i = 0; i < lift.length; i++) {
            if (lift[i]<4){
                return true;
            }
        }
        return false;
    }

    private static boolean peopleAreLeft(int people) {
        return people > 0;
    }
}

