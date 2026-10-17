package Byte_Stream;

import java.io.*;

public class ByteStream_02 {
    public static void main(String[] args) throws IOException {

        try(FileInputStream file1 = new FileInputStream("Byte_Stream\\input_file.jpg");
            FileInputStream file2 = new FileInputStream("Byte_Stream\\input_file2.jpg");
            FileOutputStream mergeFile = new FileOutputStream("Byte_Stream\\merged_file.jpg")){

            byte[] file1Buffer = new byte[1024];
            byte[] file2Buffer = new byte[1024];

            int file1_byte = file1.read(file1Buffer);
            int file2_byte = file2.read(file2Buffer);

            while(file1_byte != -1){
                mergeFile.write(file1Buffer,0,file1_byte);
                file1_byte = file1.read(file1Buffer);
            }

            while(file2_byte != -1){
                mergeFile.write(file2Buffer,0,file2_byte);
                file2_byte = file2.read(file2Buffer);
            }
        }
    }
}
