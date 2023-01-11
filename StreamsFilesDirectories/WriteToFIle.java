package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFIle {
    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream
                ("C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\ Java-Advanced-Files-and-Streams\\input.txt");

        FileOutputStream out = new FileOutputStream
                ("C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\ Java-Advanced-Files-and-Streams\\02.WriteToFileOutput.txt");

        String punctuation = ",.!?";

        byte[] oneByte = in.readAllBytes();
        for (byte b : oneByte) {

                if (!punctuation.contains((char) b + "")) {
                    out.write(b);

            }
        }
    }
}
