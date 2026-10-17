import java.io.*;
import java.util.*;

public class FileHandling_04 {
    public static void main(String[] args) throws IOException {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("file_01"))) {
            String line = reader.readLine();
            while(line != null){
                line = line.replaceAll("\\s+", " ");
                if(line.trim().length() != 0){
                    String words[] = line.split(" ");
                    for(String word : words){
                        word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                        if(word.length() != 0)
                            map.put(word,map.getOrDefault(word, 0)+1);
                    }
                }
                line = reader.readLine();
            }
            for (Map.Entry<String,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() +": "+entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }
}
