package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> courses = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = sc.nextLine();

        while (!input.equals("course start")) {
            boolean contains = true;
            String[] tokens = input.split(":");
            String cmd = tokens[0];
            String title = tokens[1];
            int indexOfTitle = courses.indexOf(title);
            if (!courses.contains(tokens[1])) {
                contains = false;
            }
            String exercise = title + "-Exercise";
            if (cmd.equals("Add")) {
                if (!contains) {
                    courses.add(courses.size(), tokens[1]);
                }
            } else if (cmd.equals("Insert")) {
                if (!contains) {
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < courses.size()) {
                        courses.add(index, title);
                    }
                }
            } else if (cmd.equals("Remove")) {
                if (contains) {
                    courses.remove(title);
                    courses.remove(exercise);
                }
            } else if (cmd.equals("Swap")) {
                String title2 = tokens[2];
                int index2 = courses.indexOf(title2);

                if (contains && courses.contains(title2)) {
                    courses.set(index2, title);
                    courses.set(indexOfTitle, title2);
                }
                if (courses.contains(exercise)) {
                    courses.add(courses.indexOf(title), exercise);
                }
                if (courses.contains(title2 + "-Exercise")) {
                    int indexOfEx2=courses.indexOf(title2 + "-Exercise");
                    courses.add(courses.indexOf(title2)+1,courses.remove(indexOfEx2));
                }
            } else {
                if (contains) {
                    if (!courses.contains(title + "-Exercise")) {
                        courses.add(indexOfTitle + 1, title + "-Exercise");
                    }
                } else {
                    courses.add(courses.size(), title);
                    courses.add(courses.size(), title + "-Exercise");
                }
            }
            input = sc.nextLine();
        }
        int cnt = 1;
        for (String course : courses) {
            System.out.println(cnt + "." + course);
            cnt++;
        }
    }
}
