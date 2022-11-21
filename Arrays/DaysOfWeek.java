package Arrays;

import java.util.Scanner;

public class DaysOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = Integer.parseInt(sc.nextLine());

        String[] days = new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        if (input>=1 &&input<=7){
            System.out.println(days[input-1]);
        }else {
            System.out.println("Invalid day!");
        }
    }
}
