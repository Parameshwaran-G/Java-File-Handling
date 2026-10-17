import java.io.*;

public class FileHandling_07 {
    public static void main(String[] args) throws IOException{
        int errorCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("application.log"))) {
            String line = reader.readLine();
            while(line != null){
                if(line.startsWith("ERROR:")) {
                    errorCount++;
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        }
        System.out.println("Total error count: " + errorCount);
    }
}
