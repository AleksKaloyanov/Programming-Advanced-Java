package StreamsFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\ Java-Advanced-Files-and-Streams\\input.txt");

        Scanner sc = new Scanner(file);
        FileWriter writer = new FileWriter(
                "C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\ Java-Advanced-Files-and-Streams\\04.ExtractIntegersOutput.txt");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                writer.write(sc.nextInt());
                writer.write(sc.nextLine());
            }
            sc.next();
        }
        writer.flush();
    }
}

