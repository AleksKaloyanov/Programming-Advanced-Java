package StreamsFilesDirectories;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream
                ("C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        int oneByte = fileInputStream.read();
        while (oneByte >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(oneByte));

            oneByte = fileInputStream.read();
        }

    }
}
