package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream
                ("C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\ Java-Advanced-Files-and-Streams\\input.txt");

        FileOutputStream out = new FileOutputStream
                ("C:\\Users\\1234\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesDirectories\\ Java-Advanced-Files-and-Streams\\03.CopyBytesOutput.txt");

        byte[] allBytes = in.readAllBytes();

        for (byte b : allBytes) {
            if (b == 32 || b == 10) {
                out.write((char) b);
            } else {
                String s = String.valueOf(b);
                for (int i = 0; i < s.length(); i++) {
                    out.write(s.charAt(i));
                }
            }
        }
    }
}
