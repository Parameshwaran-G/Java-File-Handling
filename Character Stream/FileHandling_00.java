import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling_00 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file_02"));
        String line = reader.readLine();
        reader.close();
        System.out.println(line);
    }
}
