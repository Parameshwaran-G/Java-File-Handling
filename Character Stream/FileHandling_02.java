import java.io.*;

public class FileHandling_02 {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("file_01");
        BufferedReader reader = new BufferedReader(file);
        int count = 0;
        try{
            String line = reader.readLine();
            while(line != null){
                count++;
            }
        }
        finally{
            reader.close();
        }
        System.out.println(count);
    }
}
