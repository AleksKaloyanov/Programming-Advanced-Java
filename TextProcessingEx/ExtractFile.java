package TextProcessingEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\\\");
        String[] file = input[input.length-1].split("\\.");
        String name = file[0];
        String extension = file[1];

        System.out.println("File name: "+name);
        System.out.println("File extension: "+extension);
    }
}
