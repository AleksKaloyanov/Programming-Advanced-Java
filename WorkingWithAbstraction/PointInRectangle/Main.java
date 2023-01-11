package WorkingWithAbstraction.PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Point2D a = new Point2D(coordinates[0], coordinates[1]);
        Point2D c = new Point2D(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(a, c);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int[] point = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point2D target = new Point2D(point[0], point[1]);

            System.out.println(rectangle.contains(target));
        }
    }
}
