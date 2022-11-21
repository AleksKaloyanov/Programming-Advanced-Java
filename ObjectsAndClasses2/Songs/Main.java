package ObjectsAndClasses2.Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("_");
            String typeList = tokens[0];
            String name = tokens[1];
            String time = tokens[2];

            Song song = new Song();
            song.setTypeList(typeList);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String type = sc.nextLine();
        if (type.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(type)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
