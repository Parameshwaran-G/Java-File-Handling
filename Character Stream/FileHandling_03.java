import java.io.*;

public class FileHandling_03 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("file_01"))){
            String line = reader.readLine();
            while(line != null){
                line = line.replaceAll("\\s+"," ");
                if(line.trim().length() != 0 ){
                    String words[] = line.split(" ");
                    count += words.length;
                }
                line = reader.readLine();
            }
        }
        System.out.println(count);
    }
}
