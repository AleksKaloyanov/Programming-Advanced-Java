package ListsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            if (!input[2].equals("not")){
                if (!guests.contains(name)){
                    guests.add(name);
                }else {
                    System.out.printf("%s is already in the list!%n",name);
                }
            }else {
                if (guests.contains(name)){
                    guests.remove(name);
                }else {
                    System.out.printf("%s is not in the list!%n",name);
                }
            }
        }
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
