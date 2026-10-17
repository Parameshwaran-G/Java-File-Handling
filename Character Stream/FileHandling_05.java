import java.io.*;
import java.util.*;

public class FileHandling_05 {
    public static void main(String[] args) throws IOException {
        LinkedHashSet<String> wordSet = new LinkedHashSet<>();
        int maxLength = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("file_02"))) {
            String line = reader.readLine();
            while(line != null){
                line = line.replaceAll("\\s+", " ");
                String words[] = line.split(" ");
                for(String word : words){
                    word = word.replaceAll("[^a-zA-Z0-9]", "");

                    if(word.length()==0){
                        continue;
                    }

                    if(maxLength < word.length()){
                        wordSet.clear();
                        maxLength = word.length();
                        wordSet.add(word);
                    }
                    if(maxLength == word.length()){
                        wordSet.add(word);
                    }
                }
                line = reader.readLine();
            }
            if(wordSet.isEmpty()){
                System.out.println("No word found in this file.");
            }
            else{
                System.out.println("Longest word length : "+maxLength);
                System.out.print("Longest words : "+String.join(", ",wordSet));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not found!!");
        } catch(NullPointerException e){
            System.out.println("File has no content");
        }
    }
}
