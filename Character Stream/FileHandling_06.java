import java.io.*;

public class FileHandling_06 {
    public static void main(String[] args) throws IOException {
        int lineCount = 0;
        int wordCount = 0;
        int characterCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("file_02"))){
            String line = reader.readLine();
            while(line != null){
                lineCount++;
                String words[] = line.replaceAll("\\s+", " ").trim().split(" ");
                wordCount += words.length;
                for(String word : words){
                    word = word.replaceAll("[^a-zA-Z0-9]", "");
                    characterCount += word.length();
                }
                line = reader.readLine();
            }
            System.out.println(lineCount+" "+wordCount+" "+characterCount);
        }
    }
}
