import java.io.*;

public class FileHandling_01 {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("file_01",true);
        writer.write(System.lineSeparator()+"My third file operation using java.");
        writer.close();
    }
}
