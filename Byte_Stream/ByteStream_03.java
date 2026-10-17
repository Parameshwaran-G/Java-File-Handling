package Byte_Stream;

import java.io.*;

public class ByteStream_03 {
    public static void main(String[] args) throws IOException {
        int totalBytes = 0;
        int readCount = 0;
        int countLessThan1024 = 0;
        int outputFileSize = 0;

        try(FileInputStream inputFile = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileOutputStream outputFile = new FileOutputStream("Byte_Stream\\output_file1.jpg")){

            byte inputBuffer[] = new byte[1024];

            int inputByte = inputFile.read(inputBuffer);

            while(inputByte != -1){
                outputFile.write(inputBuffer,0,inputByte);
                totalBytes += inputByte;
                readCount++;
                outputFileSize += inputByte;

                if(inputByte<1024){
                    countLessThan1024++;
                }

                inputByte = inputFile.read(inputBuffer);
            }
            System.out.println("Total bytes copied: "+totalBytes);
            System.out.println("Successful reads: "+readCount);
            System.out.println("Reads returning fewer than 1024: "+countLessThan1024);
            System.out.println("Output File Size: "+outputFileSize);
        }
    }
}
