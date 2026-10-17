import java.io.*;
import java.util.*;

public class FileHandling_09 {
    public static void main(String[] args) throws IOException {
        HashSet<String> errorSet = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("application.log"));
            FileWriter writer = new FileWriter("unique-errors.txt")) {
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("ERROR:") && !errorSet.contains(line)) {
                    writer.write(line);
                    writer.write(System.lineSeparator());
                }
                if (line.startsWith("ERROR:")) {
                    errorSet.add(line);
                }
                line = reader.readLine();
            }
            System.out.println("Unique errors written : "+errorSet.size());
        }
    }
}
