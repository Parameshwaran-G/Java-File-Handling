import java.io.*;

public class FileHandling_08 {
    public static void main(String[] args) throws IOException {
        int errorCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("application.log"));
            FileWriter writer = new FileWriter("error-report.txt")){
            String line = reader.readLine();
            while(line != null){
                if(line.startsWith("ERROR:")){
                    errorCount++;
                    writer.write(line);
                    writer.write("\n");
                }
                line = reader.readLine();
            }
            System.out.println("Error report generated successfully!!");
            System.out.println("Total errors : "+errorCount);
        }
    }
}
